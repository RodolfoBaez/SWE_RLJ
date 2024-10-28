package test.integration;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigInteger;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import conceptual.api.ComputeEngine;
import conceptual.api.ComputeEngineTwo;
import data.storage.DataStorage;
import network.api.UserInput;

public class ComputeEngineIntegrationTest {
	ComputeEngine ce = new ComputeEngine();
	ComputeEngineTwo ce2 = new ComputeEngineTwo();
	DataStorage ds = new DataStorage();

	@Test
	public void validateInputFromCe() {
		BigInteger[] expectedInput = { BigInteger.ONE, BigInteger.valueOf(10), BigInteger.valueOf(25) };
		// change to check the actual contents of array
		Assertions.assertArrayEquals(expectedInput, ce.getResults(), "CE Fail: Input Incorrect");
	}

	@Test
	public void validateOutputFromCeTwo() {
		double[] testArr = { 1.0, 10.0, 25.0 }; // Ensure the input is of type double[]
		double[] expectedResult = { 1.0, 3628800.0, 15511210043330985984000000.0 };
	}

	@Test
	public void validateWrittenByDs() {
		BigInteger[] mockResults = { BigInteger.ONE, BigInteger.valueOf(3628800) };
		UserInput mockUserInput = new UserInput("../input/myInput", ';', "../output/myOutput");
		String expectedString = "1;3628800"; // No space after the last element

		assertTrue(ds.setContentToWrite(mockResults, mockUserInput).equals(expectedString),
				"DS Fail: Written Output != Expected");
	}

}
