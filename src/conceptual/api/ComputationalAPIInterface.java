package conceptual.api;

public interface ComputationalAPIInterface {

    // Method to send input data from computeEngine to computeEngineTwo for computation
    void sendInputToComputeEngineTwo(InputSource inputSource);

    // Method to send the output data from computeEngineTwo to computeEngine
    void sendOutputToComputeEngine(OutputSource outputSource);
}
