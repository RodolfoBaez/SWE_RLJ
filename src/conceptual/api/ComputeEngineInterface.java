package conceptual.api;

public interface ComputeEngineInterface {
	//sending path to CE2
	//jobId to allow multiple instances to track computation
    int getInputSource(String jobId);
    
}
