package coordinator;

import conceptual.api.*;

public class ComputeRequest {

    private static final char DEFAULT_DELIMITER = ';';

    private final InputSource inputSource; // Fixed naming convention
    private final OutputSource outputSource; // Fixed naming convention
    private final char delimiter;

    // Constructor with default delimiter
    public ComputeRequest(InputSource inputSource, OutputSource outputSource) {
        this(inputSource, outputSource, DEFAULT_DELIMITER); // Default delimiter: ;
    }

    // Constructor with custom delimiter
    public ComputeRequest(InputSource inputSource, OutputSource outputSource, char delimiter) {
        this.inputSource = inputSource; // Fixed variable name
        this.outputSource = outputSource; // Fixed variable name
        this.delimiter = delimiter;
    }

    public char getDelimiter() {
        return delimiter;
    }

    public InputSource getInputSource() {
        return inputSource; // Added getter for input source
    }

    public OutputSource getOutputSource() {
        return outputSource; // Added getter for output source
    }

	
}
