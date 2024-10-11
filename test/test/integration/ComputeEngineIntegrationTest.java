package test.integration;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import conceptual.api.ComputeEngine;
import conceptual.api.ComputeEngineTwo;
import data.storage.DataStorage;
import network.api.UserInput;
import org.junit.jupiter.api.Test;

public class ComputeEngineIntegrationTest {
	ComputeEngine ce = new ComputeEngine();
	ComputeEngineTwo ce2 = new ComputeEngineTwo();
	DataStorage ds = new DataStorage();

	@Test
	public void validateInputFromCe() {
		int[] expectedInput = { 1, 10, 25 }; // Example expected input
		//change to check the actual contents of array
		assertArrayEquals("CE Fail: Input Incorrect", expectedInput, ce.getResults());
	}

	@Test
	public void validateOutputFromCeTwo() {
		double[] testArr = { 1.0, 10.0, 25.0 }; // Ensure the input is of type double[]
		double[] expectedResult = { 1.0, 3628800.0, 15511210043330985984000000.0 };
	}

	@Test
	public void validateWrittenByDs() {
		int[] mockResults = { 1, 3628800 };
		UserInput mockUserInput = new UserInput("../input/myInput", ';', "../output/myOutput");
		String expectedString = "1;3628800";  // No space after the last element

		assertTrue(ds.setContentToWrite(mockResults, mockUserInput).equals(expectedString),
				"DS Fail: Written Output != Expected");
	}

}
