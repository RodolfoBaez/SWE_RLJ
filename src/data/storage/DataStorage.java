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

	public DataStorage() {
		this(new ProcessAPI(), new ComputeEngine(), ',');
	}

	public DataStorage(ProcessAPI procApi, ComputeEngine ce, char defaultDelim) {
		processAPI = procApi;
		this.ce = ce;
	}

	public int[] readInputAsInts(UserInput ui) {
		List<Integer> numbersList = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(ui.getInputFile()))) {
			String line;
			while ((line = br.readLine()) != null) {
				numbersList.add(Integer.parseInt(line));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		// Convert List<Integer> to int[]
		return numbersList.stream().mapToInt(Integer::intValue).toArray();
	}

	@Override
	public File writeToOutputFile(String filePath, String content) {
		File outputFile = new File(filePath);

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile, true))) {
			bw.write(content);

			bw.close();

			return new File(filePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new File("errorFile");
	}

	@Override
	public String setContentToWrite(int[] computedOutput, UserInput ui) {
		// Check if the computeResults is null
		if (!computedOutput.equals(null)) {
			// Format content for output file
			String content = "";
			for (double i : computedOutput) {
				content += (i + ui.getDelimitter() + " ");
			}
			return content;
		} else {// TODO: Throw an exception here instead
			throw new IllegalArgumentException("computedOutput should not be null");
		}
	}

	@Override
	public File getOutputFile(String fileName) {
		return new File("../output/" + fileName);
	}

}
