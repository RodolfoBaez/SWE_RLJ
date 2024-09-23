package process.api;

public interface ProcessInterface {
	InputSource getInputSrc(ComputeEngine ce);

	OutputSource getOutputSrc(ComputeEngine ce);

	DSCode readFromInput(DataStorage ds);

	DSCode writeToOutput(DataStorage ds);
}
