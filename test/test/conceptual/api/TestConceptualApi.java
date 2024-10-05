package test.conceptual.api;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import conceptual.api.ComputationalAPI;
import conceptual.api.ComputeEngine;
import conceptual.api.ComputeEngineTwo;

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
        // Use an integer since performComputation expects int, not Path
        int mockData = 123;  // Example input data
        int mockResult = 42; // The expected integer result

        // Mock the behavior of the ComputeEngineTwo
        when(mockComputeEngineTwo.performComputation(mockData)).thenReturn(mockResult);

        // Call the sendInputToComputeEngineTwo method
        computationalAPI.sendInputToComputeEngineTwo(mockData);

        // Verify interactions
        verify(mockComputeEngineTwo).performComputation(mockData);  // Check that computation was performed
        verify(mockComputeEngine).getOutput(mockResult);          // Verify that the result was sent to ComputeEngine
    }

    
}

