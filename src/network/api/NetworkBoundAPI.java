package network.api;

public class NetworkBoundAPI {
	public void prototype (UserInput uI, ComputeE cE) {
		
		
		//reads input from user 
		UserInput input = uI.getInput();
		char delimiter = uI.getdelimiter();
		
		
		//reads out put from compute engine 
		ComputeE output = cE.getOutput(input,delimiter);
		
		
	}
}
