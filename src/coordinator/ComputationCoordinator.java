package coordinator;

public interface ComputationCoordinator {

	ComputationResultCode compute(String inputFilePath, char delimiter, String outputFilePath);

}
