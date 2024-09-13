package process.api;

public interface ComputeEngine {
	InputSource getInputSrc(ComputeEngine ce);
	
	OutputSource getOutputSrc(ComputeEngine ce);
}