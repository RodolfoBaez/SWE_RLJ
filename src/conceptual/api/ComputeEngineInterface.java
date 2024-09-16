package conceptual.api;

public interface ComputeEngineInterface {
    InputSource getInputSource(String jobId);
    void writeOutput(String jobId, OutputSource outputSource);
}
