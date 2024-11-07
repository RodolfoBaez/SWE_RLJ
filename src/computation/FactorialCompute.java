package computation;

import java.util.concurrent.RecursiveTask;
import java.util.concurrent.ForkJoinPool;

public class FactorialCompute {

	private static final ForkJoinPool forkJoinPool = new ForkJoinPool();

	public static long factorial(int n) {
		// Validate input
		if (n < 0) {
			throw new IllegalArgumentException("Input must be a non-negative integer.");
		}

		// Use ForkJoinPool to compute factorial in parallel
		return forkJoinPool.invoke(new FactorialTask(1, n));
	}

	// RecursiveTask to calculate factorial in a range
	private static class FactorialTask extends RecursiveTask<Long> {
		private final int start;
		private final int end;

		private FactorialTask(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		protected Long compute() {
			// Threshold to switch to sequential processing
			if (end - start <= 5) {
				return sequentialFactorial(start, end);
			} else {
				// Split the task
				int mid = (start + end) / 2;
				FactorialTask lowerHalf = new FactorialTask(start, mid);
				FactorialTask upperHalf = new FactorialTask(mid + 1, end);

				// Fork the lower half and compute the upper half in parallel
				lowerHalf.fork();
				long upperResult = upperHalf.compute();
				long lowerResult = lowerHalf.join();

				return lowerResult * upperResult;
			}
		}

		private long sequentialFactorial(int start, int end) {
			long result = 1;
			for (int i = start; i <= end; i++) {
				result *= i;
			}
			return result;
		}
	}
}
