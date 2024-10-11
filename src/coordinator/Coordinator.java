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

	// Constructor to initialize the NetworkAPI, ProcessAPI, DataStorage, and
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
	@Override
	public ComputationResultCode compute(UserInput userInput) {
		// Validate the UserInput parameter
		if (userInput == null) {
			return computeResult(false, "UserInput cannot be null");
		}

		//  specific validations
		// if (!userInput.isValid()) {
		//     return computeResult(false, "Invalid UserInput data");
		// }

		try {
			// Step 1: Delegate the request to the NetworkAPI to handle user input
			networkAPI.prototype(computeEngine); // Task a

			// Step 2: Delegate the request to ProcessAPI to handle data storage (reading
			// integers)
			int[] integersToCompute = processAPI.prototype(userInput); // Task b

			// If both processes are successful, return a success message
			return ComputationResultCode.SUCCESS;

		} catch (Exception e) {
			// If an error occurs in either task, return a failure message
			e.printStackTrace();
			return ComputationResultCode.ERROR;
		}
	}

	public ComputationResultCode computeResult(boolean success, String message) {
		// Return success or error based on the provided boolean
		return success ? ComputationResultCode.SUCCESS : ComputationResultCode.ERROR; // Adjust as needed
	}

	@Override
	public ComputationResultCode compute(String inputFilePath, char delimiter, String outputFilePath) {
		return null;
	}
}
