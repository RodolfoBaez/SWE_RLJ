package process.api;

import conceptual.api.*;

public class ProcessAPI {
	public void prototype(ComputeEngine ce, DataStorage ds) {
		// get input src from CE
		InputSource input = ce.getInputSrc(ce);
		// get output src from CE
		OutputSource output = ce.getOutputSrc(ce);
		// write to Output
		DSCode outputCode = ds.writeToOutput(output);
		// read from Input
		DSCode inputCode = ds.readFromInput(input);
	}
}