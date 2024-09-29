package conceptual.api;

import java.nio.file.Path;

public interface ComputeEngineInterface {
	//sending path to CE2
	//jobId to allow multiple instances to track computation
    Path getInputSource(String jobId);
    
    //stores individual outputs with an jobId
    void writeOutput(int outputData);
}
