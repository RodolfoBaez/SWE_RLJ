package conceptual.api;

public class ComputeEngine implements ComputeEngineInterface {

    private int computedResultOutput; // Variable to store the computed result


    public double[] getResults() {
        double[] defaultArr = { 1.0, 3628800.0, 15511210043330985984000000.0 };
        return defaultArr;
    }

    // Method to perform a computation and store the result
    public void setOutput(int computedResult) {
        // Store the computed result
        this.computedResultOutput = computedResult; 
    }

    // Method to retrieve the last computed output
    public int getOutput() {
        return computedResultOutput; // Return the last computed result
    }
    
    public double[] getInputSource(String input) {
        // Logic to convert input to double[] (this is just an example)
        // Modify as needed for your implementation
        return new double[]{1.0, 10.0, 25.0}; // Example return
    }
}

