package conceptual.api;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ComputeEngine implements ComputeEngineInterface {
	
	public InputSource getInputSource(String jobId) {
		// Implement logic to retrieve InputSource
		return new InputSource();
	}

	public void writeOutput(String jobId, OutputSource outputSource) {
		// Implement logic to format and write the output from OutputSource
	}

	public double[] getResults() {
		double[] defaultArr = { 1.0, 3628800.0, 15511210043330985984000000.0 };
		return defaultArr;
	}
}
