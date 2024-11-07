package conceptual.api;

import network.api.UserInput;

public class ComputeEngine implements ComputeEngineInterface {

	private int computedResultOutput; // Variable to store the computed result

	// method to return computed results to processAPI to send to data storage
	public int[] getResults() {
		int[] defaultArr = { 1, 10, 25 };
		return defaultArr;
	}

	// Method to perform a computation and store the result
	public void setOutput(int computedResult) {
		// Store the computed result
		this.computedResultOutput = computedResult;
	}

	// Method to retrieve the last computed output
	public int getOutput() {
		return this.computedResultOutput; // Return the last computed result
	}

	// TODO: implement logic to handle multiple jobs
	@Override
	public UserInput getInputSource(String jobId) {
		// TODO Auto-generated method stub
		return null;
	}

	public void compute(int value) {
		
	}
}
