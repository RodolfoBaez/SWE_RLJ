package test.infrastructure;

import java.nio.file.Path;

public class InMemoryDataStore {

    public void process(InMemoryInputSource inputConfig, InMemoryOutputSource outputConfig) {
        // Read input path
        Path inputPath = inputConfig.getData();
        
        // Example processing based on the input path
        int result = inputPath.getFileName().toString().length(); 

        // Write the processed output as an integer
        outputConfig.writeOutput(result);
    }
}
