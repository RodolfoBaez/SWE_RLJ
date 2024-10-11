package test.network;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import conceptual.api.ComputeEngine;
import network.api.NetworkAPI;
import network.api.UserInput;

public class TestNetworkAPI {
	private NetworkAPI networkApi;
	private ComputeEngine mockComputeEngine;

	@BeforeEach
	public void setUp() {
		mockComputeEngine = mock(ComputeEngine.class);
		networkApi = new NetworkAPI(mockComputeEngine);
	}


	@Test
	public void testReceiveInputFromUser() { // Correct spelling
		UserInput expected = new UserInput("myInputPath", ';', "myOutputPath");
		UserInput recievedInput = networkApi.recieveInputFromUser("myInputPath", ';', "myOutputPath");
		Assertions.assertAll(() -> assertEquals(recievedInput.getInputFile(), expected.getInputFile()),
				() -> assertEquals(recievedInput.getDelimiter(), expected.getDelimiter()),
				() -> assertEquals(recievedInput.getOutputFile(), expected.getOutputFile()));
	}


}
