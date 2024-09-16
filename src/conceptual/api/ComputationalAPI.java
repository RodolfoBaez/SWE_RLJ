package conceptual.api;


public class ComputationalAPI implements ComputationalAPIInterface {
    private ComputeEngine computeEngine;

    public ComputationalAPIImpl(ComputeEngine computeEngine) {
        this.computeEngine = computeEngine;
    }

    @Override
    public ComputationalResponse processJob(ComputationalRequest request) {
        // Retrieve input from computeEngine
        InputSource inputSource = computeEngine.getInputSource(request.getJobId());
        Object inputData = inputSource.getData();

        // Perform computation (handled by computeEngineTwo)
        ComputeEngineTwo computeEngineTwo = new ComputeEngineTwoImpl();
        Object result = computeEngineTwo.performComputation(inputData);

        // Provide result back to computeEngine for formatting
        OutputSource outputSource = new OutputSource();
        outputSource.setData(result);
        computeEngine.writeOutput(request.getJobId(), outputSource);

        // Return response (e.g., status, output location)
        return new ComputationalResponse();
    }
}
