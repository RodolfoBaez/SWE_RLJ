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
        System.out.println("Sending input to ComputeEngineTwo.");

        // Assuming inputSource provides a String 
        String inputData = (String) inputSource.getData();  
        if (inputData == null) {
            System.out.println("Input data is empty.");
            return;
        }

        // Storing Result into Integer (since ComputeEngineTwo returns Integer)
        Integer computedResult = computeEngineTwo.performComputation(inputData);

        // Sending result to OutputSource object
        OutputSource<Integer> outputSource = new OutputSource<Integer>();
        outputSource.setData(computedResult);

    }
    
    // Implementation for sending output to ComputeEngine
    public void sendOutputToComputeEngine(OutputSource outputSource) {
        System.out.println("Sending output to ComputeEngine.");

        computeEngine.writeOutput("job#", outputSource);
    }
 }
