package network.api;

import java.io.File;
import java.util.Objects;

public class UserInput {
	private File inputFile;
	private char delimiter;
	private File outputFile;

	public UserInput(String inputFilePath, char delim, String outputFilePath) {
		inputFile = new File(inputFilePath);
		delimiter = delim;
		outputFile = new File(outputFilePath);
	}

	public UserInput(String inputFilePath, String outputFilePath) {
		inputFile = new File(inputFilePath);
		delimiter = ','; // Default delimiter
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

	// Override equals to compare the contents of UserInput
	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		UserInput userInput = (UserInput) o;
		return delimiter == userInput.delimiter &&
				Objects.equals(inputFile.getPath(), userInput.inputFile.getPath()) &&
				Objects.equals(outputFile.getPath(), userInput.outputFile.getPath());
	}


	// Override hashCode to maintain consistency with equals
	@Override
	public int hashCode() {
		return Objects.hash(inputFile.getPath(), delimiter, outputFile.getPath());
	}
}
