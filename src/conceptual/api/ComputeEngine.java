package conceptual.api;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ComputeEngine implements ComputeEngineInterface {

	   @Override
	public int getInputSource(String jobId) {
	  // Implement logic to retrieve integer input based on jobId

	  return 0; // placeholder
	}
	   
	public void writeOutput(String jobId, OutputSource outputSource) {
		// Implement logic to format and write the output from OutputSource
	}

	public double[] getResults() {
		double[] defaultArr = { 1.0, 3628800.0, 15511210043330985984000000.0 };
		return defaultArr;
	}

	@Override
	public void writeOutput(int outputData) {
		// TODO Auto-generated method stub
		
	}
}
