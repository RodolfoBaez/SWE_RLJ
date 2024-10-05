package process.impl;

import java.io.File;
import java.util.ArrayList;

import conceptual.api.ComputeEngine;
import data.storage.DataStorage;
import process.api.ProcessInterface;

public class ProcessAPIImpl implements ProcessInterface {
	private ComputeEngine ce;
	private DataStorage ds;

	public ProcessAPIImpl() {
		ce = new ComputeEngine();
		ds = new DataStorage();
	}

	public ProcessAPIImpl(ComputeEngine ce, DataStorage ds) {
		this.ce = ce;
		this.ds = ds;
	}

	// These methods will have tests created for them
	public void prototypeWorkflow(ComputeEngine ce, DataStorage ds) {
		// send computedResult from CE to DS
		sendResultsToDs(ce);
		// get a specific output file/s from DS
		// TODO: we may make it a singular output file or change how we index them
		ArrayList<File> outputFiles = getOutputFiles(ds);
	}

	@Override
	public String sendResultsToDs(int result) {
		return ds.setContentToWrite(result);
	}

	@Override
	public ArrayList<File> getOutputFiles(DataStorage ds) {
		return ds.getOutputFiles();
	}

	public DataStorage getDataStorage() {
		return this.ds;
	}

	public ComputeEngine getCE() {
		return this.ce;
	}

	// TODO: better method of index output files
	// Maybe create one output file and then append that with each additional run?
	// searching linearly and creating a new output file each time seems like a bad
	// idea
	// i.e. we have to decide how to handle subsequent requests
	@Override
	public File getOutputFile(DataStorage ds, String filePath, int jobNumber) throws Exception {
		File outputFile = new File("default");
		for (File f : ds.getOutputFiles()) {
			if (f.getPath().equals(filePath + jobNumber)) {
				outputFile = f;
				break;
			} else {
				continue;
			}
		}

		if (outputFile.getPath().equals("default")) {
			throw new Exception("Failed to find requested file: filepath " + filePath + " job#: " + jobNumber);
		} else {
			return outputFile;
		}
	}

	@Override
	public String sendResultsToDs(ComputeEngine ce) {
		// TODO Auto-generated method stub
		return null;
	}

}