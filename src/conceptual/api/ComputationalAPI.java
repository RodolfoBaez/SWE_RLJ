package conceptual.api;

import java.nio.file.Path;

public class ComputationalAPI implements ComputationalAPIInterface {

    private ComputeEngine computeEngine;
    private ComputeEngineTwo computeEngineTwo;

    // Constructor for initializing the API with the compute engines
    public ComputationalAPI(ComputeEngine computeEngine, ComputeEngineTwo computeEngineTwo) {
        this.computeEngine = computeEngine;
        this.computeEngineTwo = computeEngineTwo;
    }

    // Implementation of sending input (Path) to ComputeEngineTwo
    @Override
    public void sendInputToComputeEngineTwo(Path inputPath) {

        // Perform computation using ComputeEngineTwo with the provided Path
        int computedResult = computeEngineTwo.performComputation(inputPath);

        // After computation, pass the result (integer) to writeOutput in ComputeEngine
        sendOutputToComputeEngine(computedResult);
    }

    // Implementation for sending output (integer) to ComputeEngine
    @Override
    public void sendOutputToComputeEngine(int outputData) {
        // Writing the output result to ComputeEngine
        computeEngine.writeOutput(outputData);
    }
}
