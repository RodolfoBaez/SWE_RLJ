package coordinator;

import network.api.UserInput;

public interface ComputationCoordinator {

	ComputationResultCode compute(UserInput userInput);

}
