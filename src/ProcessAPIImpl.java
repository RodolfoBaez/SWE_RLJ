import process.api.ComputeEngine;
import process.api.DSCode;
import process.api.DataStorage;
import process.api.InputSource;
import process.api.OutputSource;
import process.api.ProcessAPI;
import process.api.ProcessInterface;

public class ProcessAPIImpl implements ProcessInterface {
	// Empty Implementation with instance of API
	// works between the DSS and the CE for input
	// and output
	// Since DSS and CE aren't classes yet methods return null
	ProcessAPI processAPI;

	public ProcessAPIImpl(ProcessAPI p) {
		this.processAPI = p;
	}

	public InputSource getInputSrc(ComputeEngine ce) {
		// return ce.getInputSrc();
		return null;
	}

	public OutputSource getOutputSrc(ComputeEngine ce) {
		// return ce.getOutputSrc();
		return null;
	}

	public DSCode writeToOutput(DataStorage ds) {
		// return ds.writeToOutput();
		return null;
	}

	public DSCode readFromInput(DataStorage ds) {
		// return ds.readFromInput();
		return null;
	}

	// Gets here to create sanity test, will fail, DSS and CE don't exist yet
	public DataStorage getDSS() {
		return null;
	}

	public ComputeEngine getCE() {
		return null;
	}
}