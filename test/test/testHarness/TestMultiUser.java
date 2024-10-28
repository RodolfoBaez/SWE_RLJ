package test.testHarness;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import conceptual.api.ComputationalAPI;
import conceptual.api.ComputeEngine;
import conceptual.api.ComputeEngineTwo;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestMultiUser {

	private ComputationalAPI coordinator;
	// Update the input file path to reflect the new location
	private static final String INPUT_FILE_PATH = "./inputTestFile.txt";

	@BeforeEach
	public void initializeComputeEngine() {
		coordinator = new ComputationalAPI(new ComputeEngine(), new ComputeEngineTwo());
		verifyInputFileExists(INPUT_FILE_PATH);
	}

	private void verifyInputFileExists(String inputFilePath) {
		File inputFile = new File(inputFilePath);
		if (!inputFile.exists()) {
			throw new IllegalArgumentException("Input file not found: " + inputFile.getAbsolutePath());
		}
	}

	@Test
	public void compareMultiAndSingleThreaded() throws Exception {
		int nThreads = 4;
		List<TestUser> testUsers = new ArrayList<>();
		for (int i = 0; i < nThreads; i++) {
			// Pass the input file path to TestUser
			testUsers.add(new TestUser(coordinator, INPUT_FILE_PATH));
		}

		// Run single-threaded
		String singleThreadFilePrefix = "singleThreadOut";
		for (int i = 0; i < nThreads; i++) {
			File singleThreadedOut = new File(singleThreadFilePrefix + i + ".tmp");
			singleThreadedOut.deleteOnExit();
			testUsers.get(i).run(singleThreadedOut.getCanonicalPath());
		}

		// Run multithreaded
		ExecutorService threadPool = Executors.newCachedThreadPool();
		List<Future<?>> results = new ArrayList<>();
		String multiThreadFilePrefix = "multiThreadOut";
		for (int i = 0; i < nThreads; i++) {
			File multiThreadedOut = new File(multiThreadFilePrefix + i + ".tmp");
			multiThreadedOut.deleteOnExit();
			String multiThreadOutputPath = multiThreadedOut.getCanonicalPath();
			TestUser testUser = testUsers.get(i);
			int finalI = i;
			results.add(threadPool.submit(() -> {
				try {
					testUser.run(multiThreadOutputPath);
				} catch (Exception e) {
					// Log the exception to identify issues
					System.err.println("Error processing user " + finalI + ": " + e.getMessage());
					e.printStackTrace();
					throw e; // Rethrow to ensure the future fails
				}
			}));
		}

		// Wait for all multithreaded tasks to complete
		for (Future<?> future : results) {
			try {
				future.get();
			} catch (Exception e) {
				// Log any exceptions from the futures
				System.err.println("Exception during multithreaded execution: " + e.getMessage());
				e.printStackTrace();
				throw new RuntimeException(e);
			}
		}

		// Check that the output is the same for multithreaded and single-threaded
		List<String> singleThreaded = loadAllOutput(singleThreadFilePrefix, nThreads);
		List<String> multiThreaded = loadAllOutput(multiThreadFilePrefix, nThreads);
		Assertions.assertEquals(singleThreaded, multiThreaded);
	}

	private List<String> loadAllOutput(String prefix, int nThreads) throws IOException {
		List<String> result = new ArrayList<>();
		for (int i = 0; i < nThreads; i++) {
			File outputFile = new File(prefix + i + ".tmp");
			result.addAll(Files.readAllLines(outputFile.toPath()));
		}
		return result;
	}
}
