package test.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;

import conceptual.api.ComputeEngine;
import conceptual.api.ComputeEngineTwo;
import data.storage.DataStorage;
import network.api.UserInput;

public class ComputeEngineIntegrationTest {
    ComputeEngine ce = new ComputeEngine();
    ComputeEngineTwo ce2 = new ComputeEngineTwo();
    DataStorage ds = new DataStorage();

    @org.junit.Test
    public void validateInputFromCe() {
        double[] expectedInput = { 1.0, 10.0, 25.0 }; // Example expected input
        assertArrayEquals(expectedInput, ce.getInputSource("0100100001101001"), "CE Fail: Input Incorrect");
    }

    @org.junit.Test
    public void validateOutputFromCeTwo() {
        double[] testArr = { 1.0, 10.0, 25.0 }; // Ensure the input is of type double[]
        double[] expectedResult = { 1.0, 3628800.0, 15511210043330985984000000.0 };
    }

    @org.junit.Test
    public void validateWrittenByDs() {
        int[] mockResults = { 1, 3628800 };
        UserInput mockUserInput = new UserInput("../input/myInput", ';', "../output/myOutput");
        String expectedString = "1; 3628800";

        assertEquals(ds.setContentToWrite(mockResults, mockUserInput), expectedString,
                "DS Fail: Written Output != Expected");
    }
}
