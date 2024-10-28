package coordinator;

import java.math.BigInteger;

import conceptual.api.ComputationalAPI;
import network.api.NetworkAPI;
import network.api.UserInput;
import process.api.ProcessAPI;

public class Coordinator implements ComputationCoordinator {

	private final NetworkAPI networkAPI;
	private final ProcessAPI processAPI;
	private final ComputationalAPI computationalAPI;

	public Coordinator(NetworkAPI networkAPI, ProcessAPI processAPI, ComputationalAPI computationalAPI) {
		this.networkAPI = networkAPI;
		this.processAPI = processAPI;
		this.computationalAPI = computationalAPI;
	}

	@Override
	public void compute(String inputFilePath, char delimiter, String outputFilePath) {
		UserInput userInput = networkAPI.recieveInputFromUser(inputFilePath, delimiter, outputFilePath);
		int[] integersToCompute = processAPI.getIntegersToCompute(userInput);
		// TODO: joe's debug printlns, add more thorough testing for process
//		for (int i : integersToCompute) {
//			System.out.println(i);
//		}
		BigInteger[] computedFactorials = computationalAPI.sendInputToComputeEngineTwo(integersToCompute);
//		for (BigInteger i : computedFactorials) {
//			System.out.println(i);
//		}
		processAPI.writeToOutputFile(computedFactorials, userInput);
	}

	public ComputationResultCode computeResult(boolean success, String message) {
		// Return success or error based on the provided boolean
		return success ? ComputationResultCode.SUCCESS : ComputationResultCode.ERROR; // Adjust as needed
	}
}
