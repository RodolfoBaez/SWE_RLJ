package conceptual.api;

public class ComputationalAPI implements ComputationalAPIInterface {

	private ComputeEngine computeEngine;
	private ComputeEngineTwo computeEngineTwo;

	// Constructor for initializing the API with the compute engines
	public ComputationalAPI(ComputeEngine computeEngine, ComputeEngineTwo computeEngineTwo) {
		this.computeEngine = computeEngine;
		this.computeEngineTwo = computeEngineTwo;
	}

	// Implementation of sending input (integer) to ComputeEngineTwo
	@Override
	public long[] sendInputToComputeEngineTwo(int[] input) {
		return computeEngineTwo.performComputation(input);
	}

	// Implementation for sending output (integer) to ComputeEngine
	@Override
	public void sendOutputToComputeEngine(int computedResult) {
		// Writing the output result to ComputeEngine
		computeEngine.setOutput(computedResult);
	}

}
