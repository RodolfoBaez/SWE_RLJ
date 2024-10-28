package conceptual.api;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ComputationalAPI implements ComputationalAPIInterface {

    private ComputeEngine computeEngine;
    private ComputeEngineTwo computeEngineTwo;

    // Constructor for initializing the API with the compute engines
    public ComputationalAPI(ComputeEngine computeEngine, ComputeEngineTwo computeEngineTwo) {
        this.computeEngine = computeEngine;
        this.computeEngineTwo = computeEngineTwo;
    }

    // Method for processing the job
    public void processJob(String inputPath, String outputPath, char delimiter) {
        try {
            // Read all lines from the input file
            List<String> inputLines = Files.readAllLines(Paths.get(inputPath));

            // For each line, parse the input data, perform computation, and write output
            for (String line : inputLines) {
                int inputData = Integer.parseInt(line.trim());

                // Send the input data to ComputeEngineTwo for computation
                sendInputToComputeEngineTwo(inputData);
            }

            // Write the final output result to the output file
            int finalOutput = computeEngine.getOutput();
            Files.write(Paths.get(outputPath), String.valueOf(finalOutput).getBytes());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sendInputToComputeEngineTwo(int inputData) {
        // Perform computation using ComputeEngineTwo with the provided integer
        int computedResult = computeEngineTwo.performComputation(inputData);

        // After computation, pass the result (integer) to writeOutput in ComputeEngine
        sendOutputToComputeEngine(computedResult);
    }

    @Override
    public void sendOutputToComputeEngine(int computedResult) {
        // Writing the output result to ComputeEngine
        computeEngine.setOutput(computedResult);
    }
}
