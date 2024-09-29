package test.process.api;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.File;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import conceptual.api.ComputeEngine;
import data.storage.DataStorage;
import process.impl.ProcessAPIImpl;

public class TestProcessAPI {
	private DataStorage mockDS;
	private ComputeEngine mockCE;
	private ProcessAPIImpl processAPI;

	@BeforeEach
	public void setUp() {
		mockCE = mock(ComputeEngine.class);

		mockDS = mock(DataStorage.class);

		processAPI = new ProcessAPIImpl(mockCE, mockDS);
	}

	@Test
	public void testSendResults() {
		double[] mockResults = { 1.0, 2.0, 3.0 };

		// Get our computed results from CE
		when(mockCE.getResults()).thenReturn(mockResults);
		// Convert to string ready to write
		when(mockDS.setContentToWrite(mockResults)).thenReturn("1.0, 2.0, 3.0");

		// call send results
		processAPI.sendResultsToDs(mockCE);

		// verify CE and DS methods were called
		verify(mockCE).getResults();
		verify(mockDS).setContentToWrite(mockResults);
	}

	@Test
	public void getOutputFiles() {
		ArrayList<File> mockFiles = new ArrayList<>();

		when(mockDS.getOutputFiles()).thenReturn(mockFiles);

		processAPI.getOutputFiles(mockDS);

		verify(mockDS).getOutputFiles();
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