package conceptual.api;

public class ComputationalAPI implements ComputationalAPIInterface {
    private ComputeEngine computeEngine;
    private ComputeEngineTwo computeEngineTwo;

    public ComputationalAPI(ComputeEngine computeEngine, ComputeEngineTwo computeEngineTwo) {
        this.computeEngine = computeEngine;
        this.computeEngineTwo = computeEngineTwo;
    }

    @Override
    public void sendInputToComputeEngineTwo(InputSource inputSource) {
        // Get data from input source provided by computeEngine
        Object inputData = inputSource.getData();

        // Send data to computeEngineTwo for computation
        Object computedResult = computeEngineTwo.performComputation(inputData);

        // Create an OutputSource object to store the result
        OutputSource outputSource = new OutputSource();
        outputSource.setData(computedResult);

        // Send computed result back to computeEngine
        sendOutputToComputeEngine(outputSource);
    }

    @Override
    public void sendOutputToComputeEngine(OutputSource outputSource) {
        // Use the computeEngine to format and write the output
        computeEngine.writeOutput("job#", outputSource);
    }
}
