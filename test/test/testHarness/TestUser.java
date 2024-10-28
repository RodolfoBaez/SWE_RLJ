package test.testHarness;

import conceptual.api.ComputationalAPI;

import java.io.File;
import java.net.URL;

public class TestUser {

	// Coordinator that handles computation between user and engine
	private final ComputationalAPI coordinator;

	public TestUser(ComputationalAPI coordinator, String inputFilePath) {
		this.coordinator = coordinator;
	}

	public void run(String outputPath) {
		char delimiter = ';';

		// Use ClassLoader to locate the input file in the resources
		URL resource = getClass().getClassLoader().getResource("test/inputTestFile.txt");
		if (resource == null) {
			throw new IllegalArgumentException("Input file not found in resources");
		}

		// Get the input file path
		String inputPath;
		try {
			inputPath = new File(resource.toURI()).getPath();
		} catch (Exception e) {
			throw new RuntimeException("Failed to get input file path", e);
		}

		// Run the computation using the coordinator
		coordinator.processJob(inputPath, outputPath, delimiter);
	}
}
