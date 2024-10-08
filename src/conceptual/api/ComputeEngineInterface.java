package conceptual.api;

import network.api.UserInput;

public interface ComputeEngineInterface {
	// sending path to CE2
	// jobId to allow multiple instances to track computation
	UserInput getInputSource(String jobId);

}
