
package coordinator;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import conceptual.api.ComputationalAPI;
import conceptual.api.ComputeEngine;
import data.storage.DataStorage;
import network.api.NetworkAPI;
import network.api.UserInput;
import process.api.ProcessAPI;

public class Coordinator implements ComputationCoordinator {

	private final NetworkAPI networkAPI;
	private final ProcessAPI processAPI;
	private final ComputeEngine computeEngine;
	private final ComputationalAPI computationalAPI;

	private static final int MAX_THREADS = 4; // Upper bound for the number of threads

	// Thread pool with a fixed number of threads
	private final ExecutorService threadPool = Executors.newFixedThreadPool(MAX_THREADS);

	public Coordinator(NetworkAPI networkAPI, ProcessAPI processAPI, DataStorage dataStorage,
			ComputeEngine computeEngine, ComputationalAPI computationalAPI) {
		this.networkAPI = networkAPI;
		this.processAPI = processAPI;
		this.computeEngine = computeEngine;
		this.computationalAPI = computationalAPI;
	}

	public ComputationResultCode compute(String inputFilePath, char delimiter, String outputFilePath) {
		if (inputFilePath.equals(null)) {
			return computeResult(false, "UserInput cannot be null");
		}

		try {
			// Delegate the request to NetworkAPI and ProcessAPI
			UserInput userInput = networkAPI.recieveInputFromUser(inputFilePath, delimiter, outputFilePath);
			int[] integersToCompute = processAPI.getIntegersToCompute(userInput);
			BigInteger[] computedFactorials = computationalAPI.sendInputToComputeEngineTwo(integersToCompute);

			processAPI.writeToOutputFile(computedFactorials, userInput);
			// Create and submit tasks to the thread pool for concurrent computation
			List<Future<Void>> results = new ArrayList<>();
			for (int i = 0; i < integersToCompute.length; i++) {
				final int value = integersToCompute[i];
				results.add(threadPool.submit(() -> {
					computeEngine.compute(value); // Or the relevant compute method
					return null;
				}));
			}

			// Wait for all tasks to complete
			for (Future<Void> result : results) {
				result.get(); // Blocking call to ensure each computation completes
			}

			return ComputationResultCode.SUCCESS;

		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
			return ComputationResultCode.ERROR;
		}
	}

	public ComputationResultCode computeResult(boolean success, String message) {
		return success ? ComputationResultCode.SUCCESS : ComputationResultCode.ERROR;
	}
}
