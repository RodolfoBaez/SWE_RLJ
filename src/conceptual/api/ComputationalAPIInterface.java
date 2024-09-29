package conceptual.api;

import java.nio.file.Path;

public interface ComputationalAPIInterface {

    // Method to send the input path from ComputeEngine to ComputeEngineTwo for computation
    void sendInputToComputeEngineTwo(Path inputPath);

    // Method to send the output integer from ComputeEngineTwo to ComputeEngine
    void sendOutputToComputeEngine(int outputData);
}
