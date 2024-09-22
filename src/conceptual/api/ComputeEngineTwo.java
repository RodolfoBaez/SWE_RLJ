package conceptual.api;

public class ComputeEngineTwo implements ComputeEngineTwoInterface<String, Integer> {
    
    public Integer performComputation(String inputData) {

    	return inputData.length(); // returning integer
    } 

} 
