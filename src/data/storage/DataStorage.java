package data.storage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import conceptual.api.ComputeEngine;
import process.impl.ProcessAPIImpl;

public class DataStorage implements DataStorageInterface {
	private ProcessAPIImpl p;
	private ComputeEngine ce;
	private char delimitter;
	private static int fileCounter = 0;
	private static ArrayList<File> outputFiles;

	public DataStorage() {
		this(new ProcessAPIImpl(), new ComputeEngine());
	}

	public DataStorage(ProcessAPIImpl p, ComputeEngine ce) {
		this.p = p;
		this.ce = ce;
	}

	@SuppressWarnings("unused")
	private void prototypeWorkFlow(double[] computedOutput) {
		// Compute Engine performed factorial on some input,
		// grab computed results from CE with process API,
		// convert results into content we can pass to BufferedWriter,
		// write to output file
		writeToOutputFile("ourOutputFile", setContentToWrite(computedOutput));
	}

	@Override
	public File writeToOutputFile(String filePath, String content) {
		try {
			// TODO: add checks to see if filePath is valid
			File outputFile = new File(filePath + fileCounter);
			BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile));
			outputFiles.add(outputFile);
			fileCounter += 1;

			bw.write(content);

			bw.close();

			// FileWriter should create a file with the passed path,
			// or overwrite if a file already exits there
			return new File(filePath);
		} catch (IOException e) {
			// Alternatively, if there isn't a file
			// and FileWriter fails to make one
			e.printStackTrace();
		}
		// print stack trace and return a default errorFile
		return new File("errorFile");
	}

	@Override
	public String setContentToWrite(double[] computedOutput) {
		// Check if the computeResults is null
		if (!computedOutput.equals(null)) {
			// Format content for output file
			String content = "";
			for (double i : computedOutput) {
				content += (i + delimitter + " ");
			}
			return content;
		} else
			return "Failure to create content for Output";
	}

	@Override
	public ArrayList<File> getOutputFiles() {
		return outputFiles;
	}

}
