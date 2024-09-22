package test.infrastructure;

import java.util.List;

public class InMemoryDataStore {

    public void process(InMemoryInputSource inputConfig, InMemoryOutputSource outputConfig) {
        // Read input 
        List<Integer> inputData = inputConfig.getData();

        // Process and write output
        for (Integer input : inputData) {
            String result = "Processed: " + input;  
            outputConfig.writeOutput(result);
        }
    }
}
