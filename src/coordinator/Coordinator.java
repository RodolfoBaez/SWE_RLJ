package coordinator;

import conceptual.api.ComputeEngine;
import data.storage.DataStorage;
import network.api.NetworkAPI;
import network.api.UserInput;
import process.api.ProcessAPI;

public class Coordinator implements ComputationCoordinator {

    private final NetworkAPI networkAPI;
    private final ProcessAPI processAPI;
    private final DataStorage dataStorage;
    private final ComputeEngine computeEngine;

    // Constructor to initialize the NetworkBoundAPI, ProcessAPI, DataStorage, and
    // ComputeEngine components
    public Coordinator(NetworkAPI networkAPI, ProcessAPI processAPI, DataStorage dataStorage,
            ComputeEngine computeEngine) {
        this.networkAPI = networkAPI;
        this.processAPI = processAPI;
        this.dataStorage = dataStorage;
        this.computeEngine = computeEngine;
    }

    // Method to receive the user request, start computation, and handle data
    // storage interaction
    public ComputationResult startComputation(UserInput userInput) {
        try {
            // Step 1: Delegate the request to the NetworkBoundAPI to handle user input
            networkAPI.prototype(computeEngine); // Task a

            // Step 2: Delegate the request to ProcessAPI to handle data storage (reading
            // integers)
            processAPI.prototype(computeEngine, dataStorage, userInput); // Task b

            // If both processes are successful, return a success message
            return new ComputationResult(true, "Computation and data handling successful");

        } catch (Exception e) {
            // If an error occurs in either task, return a failure message
            return new ComputationResult(false, "Computation failed: " + e.getMessage());
        }
    }
}
