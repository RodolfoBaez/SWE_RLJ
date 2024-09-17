package network.api;

public class NetworkBoundAPI {
	public void prototype(UserInput userInput, ComputeE computeEngine) {
		
		
		//reads input from user 
		UserInput input = userInput.getInput();
		char delimiter = userInput.getdelimiter();
		
		
		//reads out put from compute engine 
		ComputeE output = computeEngine.getOutput(input,delimiter);
		
		
	}
}
