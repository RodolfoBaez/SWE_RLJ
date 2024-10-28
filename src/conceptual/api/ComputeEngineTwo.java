package conceptual.api;

public class ComputeEngineTwo implements ComputeEngineTwoInterface {

	@Override
	public int performComputation(int inputData) {
		// Implement actual computation logic here
		return 0;
	}

	public long[] performComputation(int[] inputArr) {
		long[] computedFactorials = new long[inputArr.length];

		// traverse array of inputs
		for (int i = 0; i < inputArr.length; i++) {
			// and perform factorial and store result in array for output
			computedFactorials[i] = recursiveFactorial(inputArr[i]);
		}
		return computedFactorials;
	}

	public long recursiveFactorial(int n) {
		if (n == 0 || n == 1) {
			return 1;
		}
		return n * recursiveFactorial(n - 1);
	}
}
