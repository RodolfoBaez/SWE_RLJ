package network.api;

import conceptual.api.ComputeEngine;

//Handle input from text file for compute engine
public class NetworkAPI {
	private final ComputeEngine computeEngine;

	public NetworkAPI(ComputeEngine ce) {
		computeEngine = ce;
	}

	// For Coordinator to build example workFlow
	public UserInput prototype(String inputFilePath, char delimiter, String outputFilePath) {
		return recieveInputFromUser(inputFilePath, delimiter, outputFilePath);
	}

	public UserInput prototype(String inputFilePath, String outputFilePath) {
		return recieveInputFromUser(inputFilePath, outputFilePath);
	}

	// TODO: since the user is a text file, maybe we should be checking the file
	// content for delimiter?
	public UserInput recieveInputFromUser(String inputFilePath, char outputDelimitter, String outputPath) {
		return new UserInput(inputFilePath, outputDelimitter, outputPath);
	}

	public UserInput recieveInputFromUser(String inputFilePath, String outputPath) {
		return new UserInput(inputFilePath, outputPath);
	}
	//too many prototype methods need to figure out which to keep
	public void prototype(ComputeEngine computeEngine) {
	}
}
