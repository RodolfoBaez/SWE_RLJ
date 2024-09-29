package process.api;
import conceptual.api.*;

public interface DataStorage {
	public DSCode writeToOutput(OutputSource os);
	public DSCode readFromInput(InputSource is);
}