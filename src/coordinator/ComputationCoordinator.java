package coordinator;

import network.api.ComputeResult;

public interface ComputationCoordinator {

	ComputeResult compute(ComputeRequest request);

}
