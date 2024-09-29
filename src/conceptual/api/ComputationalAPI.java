package conceptual.api;

public class ComputationalAPI implements ComputationalAPIInterface {

    private ComputeEngine computeEngine;
    private ComputeEngineTwo computeEngineTwo;

    // Constructor for initializing the API with the compute engines
    public ComputationalAPI(ComputeEngine computeEngine, ComputeEngineTwo computeEngineTwo) {
        this.computeEngine = computeEngine;
        this.computeEngineTwo = computeEngineTwo;
    }

    // Implementation of sending input (integer) to ComputeEngineTwo
    @Override
    public void sendInputToComputeEngineTwo(int inputData) {
        // Perform computation using ComputeEngineTwo with the provided integer
        int computedResult = computeEngineTwo.performComputation(inputData);

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
