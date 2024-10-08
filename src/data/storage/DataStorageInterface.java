package data.storage;

import java.io.File;

import network.api.UserInput;

public interface DataStorageInterface {

	public File writeToOutputFile(String filePath, String content);

	public String setContentToWrite(int[] computedOutput, UserInput ui);

	public File getOutputFile(String fileName);
}
