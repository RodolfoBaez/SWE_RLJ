package process.api;

import java.io.File;

import conceptual.api.ComputeEngine;
import data.storage.DataStorage;
import network.api.UserInput;

//Handle interactions between compute engine and data storage
public class ProcessAPI implements ProcessInterface {
	private ComputeEngine computeEngine;
	private DataStorage dataStorage;

	public ProcessAPI() {
		computeEngine = new ComputeEngine();
		dataStorage = new DataStorage();
	}

	public ProcessAPI(ComputeEngine ce, DataStorage ds) {
		this.computeEngine = ce;
		this.dataStorage = ds;
	}

	// For Coordinator to build example workFlow
	public int[] prototype(UserInput userInput) {
		int[] integersToCompute;
		return (integersToCompute = dataStorage.readInputAsInts(userInput));
	}

	// TODO: This method doesn't make sense to me
	@Override
	public ProcessResultCode sendComputedResultsToDs(ComputeEngine ce, UserInput ui) {
		if (!dataStorage.setContentToWrite(ce.getResults(), ui).equals(null)) {
			return ProcessResultCode.SUCCESS;
		} else {
			return ProcessResultCode.ERROR;
		}
	}

	@Override
	public File getOutputFile(DataStorage ds, String filePath) {
		return ds.getOutputFile(filePath);
	}

	public DataStorage getDataStorage() {
		return this.dataStorage;
	}

	public ComputeEngine getCE() {
		return this.computeEngine;
	}
}