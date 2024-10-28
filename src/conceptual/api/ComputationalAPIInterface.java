package conceptual.api;

public interface ComputationalAPIInterface {

	// Method to send the input integer from ComputeEngine to ComputeEngineTwo for
	// computation
	long[] sendInputToComputeEngineTwo(int[] inputData);

	// Method to send the output integer from ComputeEngineTwo to ComputeEngine
	void sendOutputToComputeEngine(int outputData);
}
