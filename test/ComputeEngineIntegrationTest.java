import static org.junit.jupiter.api.Assertions.assertArrayEquals; // Use assertArrayEquals for arrays
import static org.junit.jupiter.api.Assertions.assertEquals; // Keep assertEquals for single values

import conceptual.api.ComputeEngine;
import conceptual.api.ComputeEngineTwo;
import data.storage.DataStorage;
import org.junit.jupiter.api.Test; // JUnit 5 annotation

public class ComputeEngineIntegrationTest {

    ComputeEngine ce = new ComputeEngine();
    ComputeEngineTwo ce2 = new ComputeEngineTwo();
    DataStorage ds = new DataStorage();

    @Test
    public void validateInputFromCe() {
        double[] expectedInput = { 1.0, 10.0, 25.0 }; // Example expected input
        assertArrayEquals(expectedInput, ce.getInputSource("0100100001101001"), "CE Fail: Input Incorrect");
    }

    @Test
    public void validateOutputFromCeTwo() {
        double[] testArr = { 1.0, 10.0, 25.0 }; // Ensure the input is of type double[]
        double[] expectedResult = { 1.0, 3628800.0, 15511210043330985984000000.0 };

        double[] actualResult = ce2.performComputation(testArr);
        assertArrayEquals(expectedResult, actualResult, "CE2 Fail: Computation Failed");
    }

    @Test
    public void validateWrittenByDs() {
        double[] results = { 1.0, 3628800.0, 15511210043330985984000000.0 };
        String expectedString = "1.0, 3628800.0, 15511210043330985984000000.0";

        // Assuming setContentToWrite returns the String output
        assertEquals(expectedString, ds.setContentToWrite(results), "DS Fail: Written Output != Expected");
    }
}
