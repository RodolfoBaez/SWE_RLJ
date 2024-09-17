package conceptual.api;

public class ComputationalAPI implements ComputationalAPIInterface {

    private ComputeEngine computeEngine;        
    private ComputeEngineTwo computeEngineTwo;  

    // Constructor for initializing the API with the compute engines
    public ComputationalAPI(ComputeEngine computeEngine, ComputeEngineTwo computeEngineTwo) {
        this.computeEngine = computeEngine;
        this.computeEngineTwo = computeEngineTwo;
    }

    // Implementation of sending input to ComputeEngineTwo
    public void sendInputToComputeEngineTwo(InputSource inputSource) {
        System.out.println("Sending input to ComputeEngineTwo (stub).");

        Object inputData = inputSource.getData();
        if (inputData == null) {
            System.out.println("Input data is empty (stub).");
        }
        // Storing Result into object
        Object computedResult = computeEngineTwo.performComputation(inputData);  

        // Sending result to OutputSource object
        OutputSource outputSource = new OutputSource();
        outputSource.setData(computedResult);

        // Send the output to ComputeEngine 
        sendOutputToComputeEngine(outputSource);
    }

    // Implementation for sending output to ComputeEngine
    public void sendOutputToComputeEngine(OutputSource outputSource) {
        // Actual implementation will handle the output
        System.out.println("Sending output to ComputeEngine");

        computeEngine.writeOutput("job#", outputSource);  
    }
 }
