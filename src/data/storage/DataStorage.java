package data.storage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import conceptual.api.ComputeEngine;
import conceptual.api.InputSource;
import conceptual.api.OutputSource;
import process.impl.ProcessAPIImpl;

public class DataStorage implements DataStorageInterface {
	private ProcessAPIImpl processAPI;
	private ComputeEngine ce;
	private char delimitter;
	// TODO: I think one static output file would be better and we could append w/
	// header for info like run #, timestamp, etc.
	private static int fileCounter = 0;
	private static ArrayList<File> outputFiles;

	public DataStorage() {
		this(new ProcessAPIImpl(), new ComputeEngine(), ',');
	}

	public DataStorage(ProcessAPIImpl procApi, ComputeEngine ce, char defaultDelim) {
		processAPI = procApi;
		this.ce = ce;
		// TODO: This variable needs to be set whenever a new delimiter is specified
		delimitter = defaultDelim;
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
		File outputFile = new File(filePath + fileCounter);

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(outputFile))) {
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
		return "string";
	}

	@Override
	public ArrayList<File> getOutputFiles() {
		return outputFiles;
	}

	public void setDelimitter(char delim) {
		this.delimitter = delim;
	}

	public int readInteger(InputSource inputSource) {
		// TODO Auto-generated method stub
		return 0;
	}

	public void writeOutput(OutputSource outputSource, double[] resultArray) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String setContentToWrite(int result) {
		// TODO Auto-generated method stub
		return null;
	}

	/*@Override
	public String setContentToWrite(double[] computedOutput) {
		// TODO Auto-generated method stub
		return null;
	}*/

	
}
