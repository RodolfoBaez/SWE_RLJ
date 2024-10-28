package data.storage;

import java.io.File;
import java.math.BigInteger;

import network.api.UserInput;

public interface DataStorageInterface {

	public void writeToOutputFile(UserInput ui, String content);

	public String setContentToWrite(BigInteger[] computedOutput, UserInput ui);

	public File getOutputFile(String fileName);
}
