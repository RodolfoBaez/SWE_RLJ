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
	private DataStorage mockDataStorage;
	private ComputeEngine mockComputeEngine;
	private ProcessAPI processAPI;

	@BeforeEach
	public void setUp() {
		mockComputeEngine = mock(ComputeEngine.class);

		mockDataStorage = mock(DataStorage.class);

		processAPI = new ProcessAPI(mockComputeEngine, mockDataStorage);
	}

	@Test
	public void testSendResults() {
		long[] mockResults = { 1, 2, 3 };
		UserInput mockInput = new UserInput("myInput", ';', "myOutput");
		String mockContent = "1; 2; 3";

		// Get our computed results from CE
		when(mockComputeEngine.getResults()).thenReturn(mockResults);
		// Convert to string ready to write
		when(mockDataStorage.setContentToWrite(mockResults, mockInput)).thenReturn(mockContent);

		// compare
		Assertions.assertEquals(processAPI.sendComputedResultsToDs(mockComputeEngine, mockInput),
				ProcessResultCode.SUCCESS);
	}

	@Test
	public void getOutputFiles() throws Exception {
		String mockPath = new String("../output/myMockOutputFile");
		File expected = new File(mockPath);

		when(mockDataStorage.getOutputFile(mockPath)).thenReturn(expected);

		Assertions.assertEquals(processAPI.getOutputFile(mockDataStorage, mockPath), expected);
	}

	// ProcessAPI depends on an object of DSS and CE
	@Test
	public void verifyDsConnected() {
		assertEquals(processAPI.getDataStorage().getClass(), DataStorage.class, "Failed to verify existence of DSS");
	}

	@Test
	public void verifyCeConnceted() {
		assertEquals(processAPI.getCE().getClass(), ComputeEngine.class, "Failed to verify existence of CE");
	}
}