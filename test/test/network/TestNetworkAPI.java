package test.network;

import static org.mockito.Mockito.mock;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import conceptual.api.ComputeEngine;
import network.api.NetworkAPI;
import network.api.UserInput;

public class TestNetworkAPI {
	private NetworkAPI networkApi = new NetworkAPI(mock(ComputeEngine.class));

	@Test
	public void testRecieveInputFromUser() {
		UserInput expected = new UserInput("myInputPath", ';', "myOutputPath");
		UserInput userInput = networkApi.recieveInputFromUser("myInputPath", ';', "myOutputPath");
		Assertions.assertEquals(userInput, expected);
	}

}
