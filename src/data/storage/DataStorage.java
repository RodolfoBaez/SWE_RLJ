package data.storage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import conceptual.api.ComputeEngine;
import network.api.UserInput;
import process.api.ProcessAPI;

public class DataStorage implements DataStorageInterface {
	private ProcessAPI processAPI;
	private ComputeEngine ce;
	private char defaultDelimiter;

	public DataStorage(ProcessAPI procApi, ComputeEngine ce, char defaultDelim) {
		this.processAPI = procApi;
		this.ce = ce;
		this.defaultDelimiter = defaultDelim;
	}

	// empty constructor
	public DataStorage() {
	}

	public int[] readInputAsInts(UserInput ui) {
		List<Integer> numbersList = new ArrayList<>();

		if (!ui.equals(null)) {
			try (BufferedReader br = new BufferedReader(new FileReader(ui.getInputFile()))) {
				String line;
				while ((line = br.readLine()) != null) {
					numbersList.add(Integer.parseInt(line));
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			throw new IllegalArgumentException("user input was null");
		}

		// Convert List<Integer> to int[]
		return numbersList.stream().mapToInt(Integer::intValue).toArray();
	}

	@Override
	public File writeToOutputFile(String filePath, String content) {
		File outputFile;

		if (!(filePath.equals(null) || content.equals(null))) {
			outputFile = new File(filePath);
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile, true))) {
				bw.write(content);

				bw.close();

				return new File(filePath);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return new File("errorFile");
		} else {
			throw new IllegalArgumentException("filePath or content were null");
		}
	}

	@Override
	public String setContentToWrite(long[] computedOutput, UserInput ui) {
		// Check if the computedOutput is null
		if (computedOutput != null) {
			// Use StringBuilder for efficient concatenation
			StringBuilder content = new StringBuilder();
			for (int i = 0; i < computedOutput.length; i++) {
				content.append(computedOutput[i]);
				// Append the delimiter after each element, except the last one
				if (i < computedOutput.length - 1) {
					content.append(ui.getDelimiter()); // Get delimiter from UserInput
				}
			}
			return content.toString(); // Return the final formatted string
		} else {
			// Throw an exception if computedOutput is null
			throw new IllegalArgumentException("computedOutput should not be null");
		}
	}

	@Override
	public File getOutputFile(String fileName) {
		if (!fileName.equals(null)) {
			return new File("../output/" + fileName);
		} else {
			throw new IllegalArgumentException("file name was null");
		}
	}

	public String toString() {
		return new String("DataStorage default delimiter: " + defaultDelimiter);
	}

}
