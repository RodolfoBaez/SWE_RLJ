package network.api;

import conceptual.api.ComputeEngine;

//Handle input from text file for compute engine
public class NetworkAPI {
	private final ComputeEngine computeEngine;

	public NetworkAPI(ComputeEngine ce) {
		computeEngine = ce;
	}

	public UserInput recieveInputFromUser(String inputFilePath, char outputDelimitter, String outputPath) {
		return new UserInput(inputFilePath, outputDelimitter, outputPath);
	}

	public UserInput recieveInputFromUser(String inputFilePath, String outputPath) {
		return new UserInput(inputFilePath, outputPath);
	}
}
