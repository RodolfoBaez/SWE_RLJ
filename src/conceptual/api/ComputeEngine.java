package conceptual.api;

public class ComputeEngine implements ComputeEngineInterface {

    public InputSource getInputSource(String jobId) {
        // Implement logic to retrieve InputSource
        return new InputSource();
    }

    private int computedResultOutput; // Variable to store the computed result

    // method to return computed results to processAPI to send to data storage
    public int[] getResults() {
        int[] defaultArr = { 1, 3628800 };
        return defaultArr;
    }

    // Method to perform a computation and store the result
    public void setOutput(int computedResult) {
        // Store the computed result
        this.computedResultOutput = computedResult;
    }

    // Method to retrieve the last computed output
    public int getOutput() {
        return this.computedResultOutput; // Return the last computed result
    }
}
