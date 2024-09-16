package conceptual.api;

public class ComputeEngine implements ComputeEngineInterface {
    @Override
    public InputSource getInputSource(String jobId) {
        // TODO: Implement logic to retrieve InputSource 
        return new InputSource();
    }

    @Override
    public void writeOutput(String jobId, OutputSource outputSource) {
        // TODO: Implement logic to format and write the output from OutputSource
    }
}
