import static org.junit.jupiter.api.Assertions.assertEquals;

import conceptual.api.ComputeEngine;
import conceptual.api.ComputeEngineTwo;
import process.api.DataStorageTestOnly;

public class ComputeEngineIntegrationTest {
	ComputeEngine ce = new ComputeEngine();
	ComputeEngineTwo ce2 = new ComputeEngineTwo();
	DataStorageTestOnly ds = new DataStorageTestOnly();

	@org.junit.Test
	public void validateInputFromCe() {
		double[] testArr = { 1, 10, 25 };
		// Should be assertArrayEquals since we want to compare 2 arrays
		assertEquals(ce.getInputSource("0100100001101001"), testArr, "CE Fail: Input Incorrect");
	}

	@org.junit.Test
	public void validateOutputfromCeTwo() {
		double[] testArr = { 1, 10, 25 };
		double[] expectedResult = { 1.0, 3628800.0, 15511210043330985984000000.0 };
		assertEquals(ce2.performComputation(testArr), expectedResult, "CE2 Fail: Computation Failed");
	}

	@org.junit.Test
	public void validateWrittenByDs() {
		double[] expected = { 1.0, 3628800.0, 15511210043330985984000000.0 };
		assertEquals(ds.writeToOutput(), expected, "DS Fail: Written Output != Expected");
	}

}
