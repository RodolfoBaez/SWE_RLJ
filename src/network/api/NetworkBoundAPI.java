package network.api;

public class NetworkBoundAPI {
	public void prototype(UserInput userInput, ComputeE computeEngine) {
		
		
		//reads input from user 
		String input = userInput.getInput();
		char delimiter = userInput.getdelimiter();
		
		
		//reads out put from compute engine 
		ComputeResult output = computeEngine.getOutput(userInput,delimiter);
		// return compute result 
		
	}
	
	
	
}
