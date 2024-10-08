package conceptual.api;

public class ComputeEngine implements ComputeEngineInterface {

	public InputSource getInputSource(String jobId) {
		// Implement logic to retrieve InputSource
		return new InputSource();
	}

	public void writeOutput(String jobId, OutputSource outputSource) {
		// Implement logic to format and write the output from OutputSource
	}

	public int[] getResults() {
		int[] defaultArr = { 1, 3628800 };
		return defaultArr;
	}

	public void getOutput() {
		// TODO Auto-generated method stub

	}

}
