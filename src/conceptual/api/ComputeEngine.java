package conceptual.api;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ComputeEngine implements ComputeEngineInterface {

    @Override
    public Path getInputSource(String jobId) {
        // Implement logic to retrieve the input file path based on jobId
    	// needs to connect to process API to get path from DataStorage
    	
        // For now, returning a placeholder path
        return Paths.get("/path/to/input/file/for/job/" + jobId);
    }

    @Override
    public void writeOutput(int outputData) {
        // Implement logic to format and write the output data (integer) for the given jobId
        // Placeholder: printing out result, but will need to send to Data storage via process API
        System.out.println("Output: " + outputData);

    }
}
