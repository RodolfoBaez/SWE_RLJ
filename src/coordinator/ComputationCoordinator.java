package coordinator;

import network.api.UserInput;

public interface ComputationCoordinator {

    // Method to receive the user request, start computation, and handle data
    // storage interaction
    ComputationResultCode compute(UserInput userInput);

    ComputationResultCode compute(String inputFilePath, char delimiter, String outputFilePath);

}

