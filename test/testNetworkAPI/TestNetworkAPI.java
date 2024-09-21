package testNetworkAPI;

import static org.junit.Assert.fail;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;

import network.impl.NetworkApiImpl;

import network.api.NetworkBoundAPI;



public class TestNetworkAPI{

	private NetworkApiImpl networkApi = new NetworkApiImpl((Mockito.mock(NetworkBoundAPI.class))); 

	
	

	// make mock network api object so i can call real one 
	
	@Test
	public void testInput() {
		String result = networkApi.getUserInput("Test Input");
		Assertions.assertEquals(result, "Input recived");
	}
	
	@Test 
	public void testOutput() {
		String result = networkApi.getCeOutput("Test Output");
		Assertions.assertEquals(result, "Output given");
				
	}
	
}

