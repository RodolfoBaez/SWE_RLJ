package data.storage;

import java.io.File;
import java.util.ArrayList;

public interface DataStorageInterface {

	public File writeToOutputFile(String filePath, String content);

	public String setContentToWrite(double[] computedOutput);

	public ArrayList<File> getOutputFiles();
}