package network.api;

import java.io.File;

//the 'user' in this case is an input text file
public class UserInput {
	private final File inputFile;
	private final char delimiter;
	private final File outputFile;

	public UserInput(String inputFilePath, char delim, String outputFilePath) {
		inputFile = new File(inputFilePath);
		delimiter = delim;
		outputFile = new File(outputFilePath);
	}

	public UserInput(String inputFilePath, String outputFilePath) {
		inputFile = new File(inputFilePath);
		delimiter = ',';
		outputFile = new File(outputFilePath);
	}

	public char getDelimiter() {
		return delimiter;
	}

	public File getInputFile() {
		return inputFile;
	}

	public File getOutputFile() {
		return outputFile;
	}

	public String toString() {
		return new String("inputFile: " + inputFile + " delimitter: " + delimiter + " outputFile: " + outputFile);
	}
}
