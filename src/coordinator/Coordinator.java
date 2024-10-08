package coordinator;

import conceptual.api.ComputationalAPI;
import conceptual.api.ComputeEngine;
import conceptual.api.ComputeEngineTwo;
import conceptual.api.ComputeEngineTwoInterface;
import conceptual.api.InputSource;
import conceptual.api.OutputSource;
import data.storage.DataStorage;
import network.api.ComputeResult;
import process.impl.ProcessAPIImpl;

public class Coordinator implements ComputationCoordinator {

    private final DataStorage dataStore;
    private final ComputeEngineTwoInterface computeEngine;
    private final ProcessAPIImpl processAPI;

    public Coordinator(DataStorage dataStore, ComputeEngine computeEngine, ComputeEngineTwo computeEngineTwo) {
        this.dataStore = dataStore;
        this.computeEngine = (ComputeEngineTwoInterface) computeEngine;
        new ComputationalAPI(computeEngine, computeEngineTwo);
        this.processAPI = new ProcessAPIImpl(computeEngine, dataStore);
    }

    @Override
    public ComputeResult compute(ComputeRequest request) {
        // Validate the ComputeRequest parameter
        if (request == null) {
            return computeResult(false, "ComputeRequest cannot be null");
        }

        InputSource inputSource = request.getInputSource();
        OutputSource outputSource = request.getOutputSource();

        // Validate InputSource and OutputSource
        if (inputSource == null) {
            return computeResult(false, "InputSource cannot be null");
        }
        if (outputSource == null) {
            return computeResult(false, "OutputSource cannot be null");
        }

        try {
            // Use the ProcessAPI to read the input integer
            int inputInteger = dataStore.readInteger(inputSource);
            // Validate the input integer
            if (inputInteger == Integer.MIN_VALUE) {
                return ComputeResult.FAILURE;
            }

            // Pass the integer to ComputeEngineTwo through ComputationalAPI
            int result = computeEngine.performComputation(inputInteger);
            // Handle output
            double[] resultArray = { (double) result }; // Convert int to double[]

            // Write the result to the output
            dataStore.writeOutput(outputSource, resultArray);

            // Return success result
            return ComputeResult.SUCCESS;

        } catch (Exception e) {
            // If an error occurs, return failure
            return computeResult(false, "Computation failed: " + e.getMessage());
        }
    }

    private ComputeResult computeResult(boolean success, String message) {
        // Here you would typically create a ComputeResult instance based on the success/failure
        // This is a placeholder for your actual implementation
        return success ? ComputeResult.SUCCESS : ComputeResult.FAILURE; // Adjust as needed
    }
}
