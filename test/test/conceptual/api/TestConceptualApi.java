
package test.conceptual.api;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


import conceptual.api.ComputationalAPI;
import conceptual.api.ComputeEngine;
import conceptual.api.ComputeEngineTwo;
import conceptual.api.InputSource;
import conceptual.api.OutputSource;

public class TestConceptualApi {

    private ComputeEngine mockComputeEngine;
    private ComputeEngineTwo mockComputeEngineTwo;
    private ComputationalAPI computationalAPI;
    private InputSource mockInputSource;
    private OutputSource mockOutputSource;

    @BeforeEach
    public void setUp() {
        // Mock the dependencies
        mockComputeEngine = Mockito.mock(ComputeEngine.class);
        mockComputeEngineTwo = Mockito.mock(ComputeEngineTwo.class);
        mockInputSource = Mockito.mock(InputSource.class);
        mockOutputSource = Mockito.mock(OutputSource.class);

        // Initialize the ComputationalAPI with mocked dependencies
        computationalAPI = new ComputationalAPI(mockComputeEngine, mockComputeEngineTwo);
    }

    @Test
    public void testSendInputToComputeEngineTwo() {
        // Mock the behavior of the InputSource and ComputeEngineTwo
        String mockData = "testInput";  
        Integer mockResult = 42;        

        when(mockInputSource.getData()).thenReturn(mockData);
        when(mockComputeEngineTwo.performComputation(mockData)).thenReturn(mockResult);

        // Call the sendInputToComputeEngineTwo method
        computationalAPI.sendInputToComputeEngineTwo(mockInputSource);

        // Verify interactions
        verify(mockInputSource).getData();  // Check that getData was called
        verify(mockComputeEngineTwo).performComputation(mockData);  // Check that computation was performed
    }

    @Test
    public void testSendOutputToComputeEngine() {
        // Call the sendOutputToComputeEngine method
        computationalAPI.sendOutputToComputeEngine(mockOutputSource);

        // Verify that output was sent to ComputeEngine
        verify(mockComputeEngine).writeOutput(anyString(), eq(mockOutputSource));
    }
}
