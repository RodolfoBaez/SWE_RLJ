package conceptual.api;

//generic 
public interface ComputeEngineTwoInterface<InputType, OutputType> {
    OutputType performComputation(InputType inputData);
}
