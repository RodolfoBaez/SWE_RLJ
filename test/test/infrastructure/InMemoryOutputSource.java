// In-memory implementation for OutputSource with an int
package test.infrastructure;

import conceptual.api.OutputSource;

public class InMemoryOutputSource extends OutputSource {
    private int data;

    public InMemoryOutputSource() {
        this.data = 0; // Initialize to a default value
    }

    // Method to retrieve the current output data
    public int getData() {
        return data;
    }

    // Method to write output data
    public void writeOutput(int data) {
        this.data = data; 
    }
}
