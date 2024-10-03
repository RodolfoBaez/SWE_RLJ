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

	// try to implement processapi inside datastore
	// think about combining the processapiinterface with datastorageinterfaces
    private final DataStorage dataStore; 
    private final ComputeEngineTwoInterface computeEngine;//change this to only have api here 
    private final ProcessAPIImpl processAPI; 

    // Constructor to initialize the components
    public Coordinator(DataStorage dataStore, ComputeEngine computeEngine, ComputeEngineTwo computeEngineTwo) {
        this.dataStore = dataStore;
        this.computeEngine = (ComputeEngineTwoInterface) computeEngine;
        new ComputationalAPI(computeEngine, computeEngineTwo);
        this.processAPI = new ProcessAPIImpl(computeEngine, dataStore); // Initialize ProcessAPIImpl
    }

    @Override
    public ComputeResult compute(ComputeRequest request) {
        try {
            // Step a: Receive requests from the user to start the computation
            InputSource inputSource = request.getInputSource(); 
            OutputSource outputSource = request.getOutputSource();

            // Step b: Use the ProcessAPI to read the input integer
            int inputInteger = dataStore.readInteger(inputSource);
            if (inputInteger == Integer.MIN_VALUE) { 
                return ComputeResult.FAILURE; 
            }

            // Step c: Pass the integer to ComputeEngineTwo through ComputationalAPI
            int result = computeEngine.performComputation(inputInteger);
            // Step d: Use ProcessAPI to handle output
            String contentToWrite = processAPI.sendResultsToDs(result); 
            
            // Write the result to the output
            dataStore.writeOutput(outputSource, result);
            
            // Return success result
            return ComputeResult.SUCCESS; 

        } catch (Exception e) {
            // If an error occurs, return failure
            return new ComputeResult(false, "Computation failed: " + e.getMessage());
        }
    }
}
