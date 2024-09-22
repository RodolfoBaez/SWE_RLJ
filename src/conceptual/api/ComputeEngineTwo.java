package conceptual.api;

public class ComputeEngineTwo implements ComputeEngineTwoInterface<String, Integer> {
    
    public Integer performComputation(String inputData) {
        // Implement the actual computation logic here
        return inputData.length();//returning int 
    }
}