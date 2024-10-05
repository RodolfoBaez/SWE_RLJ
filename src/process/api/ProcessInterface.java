package process.api;

import java.io.File;
import java.util.ArrayList;

import conceptual.api.ComputeEngine;
import data.storage.DataStorage;

public interface ProcessInterface {
	public String sendResultsToDs(ComputeEngine ce);

	public File getOutputFile(DataStorage ds, String filePath, int jobNumber) throws Exception;

	public ArrayList<File> getOutputFiles(DataStorage ds);

	String sendResultsToDs(int result);
}
