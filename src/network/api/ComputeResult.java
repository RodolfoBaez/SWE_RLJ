package network.api;

public interface ComputeResult {

	ComputeResult FAILURE = null;
	ComputeResult SUCCESS = null;

	ComputeResult getOutput(UserInput input, char delimiter);
	
	
}
