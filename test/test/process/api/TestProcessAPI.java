package test.process.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.File;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import conceptual.api.ComputeEngine;
import data.storage.DataStorage;
import network.api.UserInput;
import process.api.ProcessAPI;
import process.api.ProcessResultCode;

public class TestProcessAPI {
	private DataStorage mockDS;
	private ComputeEngine mockCE;
	private ProcessAPI processAPI;

	@BeforeEach
	public void setUp() {
		mockCE = mock(ComputeEngine.class);

		mockDS = mock(DataStorage.class);

		processAPI = new ProcessAPI(mockCE, mockDS);
	}

	@Test
	public void testSendResults() {
		int[] mockResults = { 1, 2, 3 };
		UserInput mockInput = new UserInput("myInput", ';', "myOutput");
		String mockContent = "1; 2; 3";

		// Get our computed results from CE
		when(mockCE.getResults()).thenReturn(mockResults);
		// Convert to string ready to write
		when(mockDS.setContentToWrite(mockResults, mockInput)).thenReturn(mockContent);

		// compare
		Assertions.assertEquals(processAPI.sendResultsToDs(mockCE, mockInput), ProcessResultCode.SUCCESS);
	}

	@Test
	public void getOutputFiles() throws Exception {
		String mockPath = new String("../output/myMockOutputFile");
		File expected = new File("myMockOutputFile");

		when(mockDS.getOutputFile(mockPath)).thenReturn(expected);

		Assertions.assertEquals(processAPI.getOutputFile(mockDS, "myMockOutputFile"), expected);
	}

	// ProcessAPI depends on an object of DSS and CE
	@Test
	public void verifyDsConnected() {
		assertEquals(processAPI.getDataStorage(), DataStorage.class, "Failed to verify existence of DSS");
	}

	@Test
	public void verifyCeConnceted() {
		assertEquals(processAPI.getCE(), ComputeEngine.class, "Failed to verify existence of CE");
	}
}