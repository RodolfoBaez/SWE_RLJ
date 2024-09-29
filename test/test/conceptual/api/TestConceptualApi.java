package test.conceptual.api;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import conceptual.api.ComputationalAPI;
import conceptual.api.ComputeEngine;
import conceptual.api.ComputeEngineTwo;

import java.nio.file.Path;

public class TestConceptualApi {

    private ComputeEngine mockComputeEngine;
    private ComputeEngineTwo mockComputeEngineTwo;
    private ComputationalAPI computationalAPI;

    @BeforeEach
    public void setUp() {
        // Mock the dependencies
        mockComputeEngine = Mockito.mock(ComputeEngine.class);
        mockComputeEngineTwo = Mockito.mock(ComputeEngineTwo.class);

        // Initialize the ComputationalAPI with mocked dependencies
        computationalAPI = new ComputationalAPI(mockComputeEngine, mockComputeEngineTwo);
    }

    @Test
    public void testSendInputToComputeEngineTwo() {
        // Mock the behavior of the ComputeEngineTwo
        Path mockData = mock(Path.class);  // Mock the Path object
        int mockResult = 42;                // The expected integer result

        when(mockComputeEngineTwo.performComputation(mockData)).thenReturn(mockResult);

        // Call the sendInputToComputeEngineTwo method
        computationalAPI.sendInputToComputeEngineTwo(mockData);

        // Verify interactions
        verify(mockComputeEngineTwo).performComputation(mockData);  // Check that computation was performed
        verify(mockComputeEngine).writeOutput(mockResult);          // Verify that the result was sent to ComputeEngine
    }

    @Test
    public void testSendOutputToComputeEngine() {
        int mockOutputValue = 42;  // Example integer output

        // Call the sendOutputToComputeEngine method
        computationalAPI.sendOutputToComputeEngine(mockOutputValue);

        // Verify that output was sent to ComputeEngine
        verify(mockComputeEngine).writeOutput(eq(mockOutputValue));  // Check that the output was written correctly
    }
}

