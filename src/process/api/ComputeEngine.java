package process.api;
import conceptual.api.*;

public interface ComputeEngine {
	InputSource getInputSrc(ComputeEngine ce);
	
	OutputSource getOutputSrc(ComputeEngine ce);
}