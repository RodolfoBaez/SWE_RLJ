package coordinator;

import conceptual.api.InputSource;
import conceptual.api.OutputSource;

public class ComputeRequest {

    private static final char DEFAULT_DELIMITER = ';';

    private final InputSource inputSource; 
    private final OutputSource outputSource; 
    private final char delimiter;

    // Constructor with default delimiter
    public ComputeRequest(InputSource inputSource, OutputSource outputSource) {
        this(inputSource, outputSource, DEFAULT_DELIMITER); // Default delimiter: ;
    }

    // Constructor with custom delimiter
    public ComputeRequest(InputSource inputSource, OutputSource outputSource, char delimiter) {
        this.inputSource = inputSource; 
        this.outputSource = outputSource; 
        this.delimiter = delimiter;
    }

    public char getDelimiter() {
        return delimiter;
    }

    public InputSource getInputSource() {
        return inputSource; 
    }

    public OutputSource getOutputSource() {
        return outputSource; 
    }

	
}
