package network.api;

public class NetworkBoundAPI {
public void prototype (UserInput UI, ComputeE CE) {
		
		
		//reads input from user 
		UserInput input = UI.getInput();
		char delimiter = UI.getdelimiter();
		
		
		//reads out put from compute engine 
		ComputeE output = CE.getOutput(input,delimiter);
		
		
	}
}
