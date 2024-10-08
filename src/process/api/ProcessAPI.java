package process.api;

import java.io.File;

import conceptual.api.ComputeEngine;
import data.storage.DataStorage;
import network.api.UserInput;

public class ProcessAPI implements ProcessInterface {
	private ComputeEngine ce;
	private DataStorage ds;

	public ProcessAPI() {
		ce = new ComputeEngine();
		ds = new DataStorage();
	}

	public ProcessAPI(ComputeEngine ce, DataStorage ds) {
		this.ce = ce;
		this.ds = ds;
	}

	// For Coordinator to build example workFlow
	public void prototype(ComputeEngine computeEngine, DataStorage dataStorage, UserInput userInput) {
		ProcessResultCode result = sendResultsToDs(computeEngine, userInput);
		int[] integersToCompute = ds.readInputAsInts(userInput);
	}

	@Override
	public ProcessResultCode sendResultsToDs(ComputeEngine ce, UserInput ui) {
		if (!ds.setContentToWrite(ce.getResults(), ui).equals(null)) {
			return ProcessResultCode.SUCCESS;
		} else {
			return ProcessResultCode.ERROR;
		}
	}

	@Override
	public File getOutputFile(DataStorage ds, String filePath) throws Exception {
		return ds.getOutputFile(filePath);
	}

	public DataStorage getDataStorage() {
		return this.ds;
	}

	public ComputeEngine getCE() {
		return this.ce;
	}
}