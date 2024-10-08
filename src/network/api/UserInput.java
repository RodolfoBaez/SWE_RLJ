package network.api;

import java.io.File;

public class UserInput {
	private File inputFile;
	private char delimitter;
	private File outputFile;

	public UserInput(String inputFilePath, char delim, String outputFilePath) {
		inputFile = new File(inputFilePath);
		delimitter = delim;
		outputFile = new File(outputFilePath);
	}

	public UserInput(String inputFilePath, String outputFilePath) {
		inputFile = new File(inputFilePath);
		delimitter = ',';
		outputFile = new File(outputFilePath);
	}

	public char getDelimitter() {
		return delimitter;
	}

	public File getInputFile() {
		return inputFile;
	}

	public File getOutputFile() {
		return outputFile;
	}
}
