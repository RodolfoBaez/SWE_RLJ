package ProcessApi;

public class PrototypeProcess {
	public void prototype(ComputeEngine ce, DataStorage ds)
	{
		//get input src from CE
		InputSource input = ce.getInputSrc();
		//get output src from CE
		OutputSource output = ce.getOutputSrc();
		//write to Output
		DSCode outputCode = ds.writeToOutput();
		//read from Input
		DSCode inputCode = ds.readFromInput();
	}
}
