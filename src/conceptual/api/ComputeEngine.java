package conceptual.api;

public class ComputeEngine implements ComputeEngineInterface {
	
	public InputSource getInputSource(String jobId) {
        //Implement logic to retrieve InputSource 
        return new InputSource();
    }

    public void writeOutput(String jobId, OutputSource outputSource) {
        //Implement logic to format and write the output from OutputSource
    }

}
