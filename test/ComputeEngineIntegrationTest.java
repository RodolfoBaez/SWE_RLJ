import static org.junit.jupiter.api.Assertions.assertArrayEquals; // Use assertArrayEquals for arrays
import static org.junit.jupiter.api.Assertions.assertEquals; // Keep assertEquals for single values

import conceptual.api.ComputeEngine;
import conceptual.api.ComputeEngineTwo;
import data.storage.DataStorage;

public class ComputeEngineIntegrationTest {
    ComputeEngine ce = new ComputeEngine();
    ComputeEngineTwo ce2 = new ComputeEngineTwo();
    DataStorage ds = new DataStorage();

    @org.junit.Test
    public void validateInputFromCe() {
        double[] testArr = { 1, 10, 25 };
        // Should be assertArrayEquals since we want to compare 2 arrays
        assertArrayEquals(testArr, ce.getInputSource("0100100001101001"), "CE Fail: Input Incorrect");
    }

    @org.junit.Test
    public void validateOutputFromCeTwo() {
        double[] testArr = { 1, 10, 25 };
        double[] expectedResult = { 1.0, 3628800.0, 15511210043330985984000000.0 };
        
        // Ensure performComputation returns a double[]
        double[] actualResult = ce2.performComputation(testArr);
        assertArrayEquals(expectedResult, actualResult, "CE2 Fail: Computation Failed");
    }

    @org.junit.Test
    public void validateWrittenByDs() {
        double[] results = { 1.0, 3628800.0, 15511210043330985984000000.0 };
        String expectedString = "1.0, 3628800.0, 15511210043330985984000000.0";
        
        // Assuming setContentToWrite returns the String output
        assertEquals(expectedString, ds.setContentToWrite(results), "DS Fail: Written Output != Expected");
    }
}
