package network.api;

import conceptual.api.ComputeEngine;

public class NetworkAPI {
	ComputeEngine ce;

	public NetworkAPI(ComputeEngine ce) {
		this.ce = ce;
	}

	// For Coordinator to build example workFlow
	public void prototype(ComputeEngine computeEngine) {
		recieveInputFromUser("myInputFilePath", ';', "myOutputFilePath");
	}

	public UserInput recieveInputFromUser(String inputFilePath, char outputDelimitter, String outputPath) {
		return new UserInput(inputFilePath, outputDelimitter, outputPath);
	}

	public UserInput recieveInputFromUser(String inputFilePath, String outputPath) {
		return new UserInput(inputFilePath, outputPath);
	}

}
