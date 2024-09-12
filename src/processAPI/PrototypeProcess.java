package processAPI;

public class PrototypeProcess {
	public void prototype(ComputeEngine CE, DataStorage DS)
	{
		//get input src from CE
		InputSource input = CE.getInputSrc();
		//get output src from CE
		OutputSource output = CE.getOutputSrc();
		//write to Output
		DSCode outputCode = DS.writeToOutput();
		//read from Input
		DSCode inputCode = DS.readFromInput();
	}
}
