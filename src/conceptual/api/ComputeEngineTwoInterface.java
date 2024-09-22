package conceptual.api;

// Generic 
public interface ComputeEngineTwoInterface<InputT, OutputT> {
    OutputT performComputation(InputT inputData);
}
