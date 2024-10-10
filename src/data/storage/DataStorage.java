package data.storage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import network.api.UserInput;

public class DataStorage implements DataStorageInterface {
	private final char defaultDelimiter;

	public DataStorage() {
		defaultDelimiter = ',';
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
	public String setContentToWrite(int[] computedOutput, UserInput ui) {
		// Check if the computeResults or userInput is null
		if (!(computedOutput.equals(null) || ui.equals(null))) {
			// Format content for output file
			String content = "";
			// Check if user supplied a delimiter
			if (!((int) ui.getDelimiter() == 0)) {
				for (double i : computedOutput) {
					content += (i + ui.getDelimiter() + " ");
				}
			} else {
				// use default if they did not
				for (double i : computedOutput) {
					content += (i + this.defaultDelimiter + " ");
				}
			}

			return content;
		} else {
			throw new IllegalArgumentException("computedOutput or ui were null");
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
