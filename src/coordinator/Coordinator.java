package coordinator;

import network.api.*;i
import conceptual.api.*;
import process.api.*;
import process.impl.*;
import data.storage.*;

public class Coordinator implements ComputationCoordinator {

    private final DataStorage dataStore; 
    private final ComputeEngine computeEngine;
    private final ComputationalAPI computationalAPI; 
    private final ProcessAPIImpl processAPI; // Reference to ProcessAPIImpl

    // Constructor to initialize the components
    public Coordinator(DataStorage dataStore, ComputeEngine computeEngine, ComputeEngineTwo computeEngineTwo) {
        this.dataStore = dataStore;
        this.computeEngine = computeEngine;
        this.computationalAPI = new ComputationalAPI(computeEngine, computeEngineTwo);
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
            computationalAPI.sendInputToComputeEngineTwo(inputInteger);

            // Step d: Use ProcessAPI to handle output
            String contentToWrite = processAPI.sendResultsToDs(computeEngine); // Get content to write
            
            // Write the result to the output
            dataStore.writeOutput(outputSource, contentToWrite);
            
            // Return success result
            return ComputeResult.SUCCESS; 

        } catch (Exception e) {
            // If an error occurs, return failure
            return new ComputeResult(false, "Computation failed: " + e.getMessage());
        }
    }
}
