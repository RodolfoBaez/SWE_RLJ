import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import process.api.ComputeEngine;
import process.api.DataStorage;
import process.api.ProcessAPI;

public class TestProcessAPI {
	private ProcessAPI mockProcApi = mock(ProcessAPI.class);
	private ProcessAPIImpl procApi = new ProcessAPIImpl(mockProcApi);

	// ProcessAPI depends on an object of DSS and CE
	@Test
	public void testDSS() {
		Assertions.assertEquals(procApi.getDSS(), DataStorage.class, "Failed to verify existence of DSS");
	}

	@Test
	public void testCE() {
		Assertions.assertEquals(procApi.getCE(), ComputeEngine.class, "Failed to verify existence of CE");

	}
}