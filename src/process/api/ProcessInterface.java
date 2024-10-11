package process.api;

import java.io.File;

import conceptual.api.ComputeEngine;
import data.storage.DataStorage;
import network.api.UserInput;

public interface ProcessInterface {
	public ProcessResultCode sendComputedResultsToDs(ComputeEngine ce, UserInput ui);

	public File getOutputFile(DataStorage ds, String filePath) throws Exception;
}
