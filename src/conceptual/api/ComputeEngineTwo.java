package conceptual.api;

import java.math.BigInteger;

public class ComputeEngineTwo implements ComputeEngineTwoInterface {

	@Override
	public int performComputation(int inputData) {
		// Implement actual computation logic here
		return 0;
	}

	public BigInteger[] performComputation(int[] inputArr) {
		BigInteger[] computedFactorials = new BigInteger[inputArr.length];

		// traverse array of inputs
		for (int i = 0; i < inputArr.length; i++) {
			// and perform factorial and store result in array for output
			computedFactorials[i] = recursiveFactorial(BigInteger.valueOf(inputArr[i]));
		}
		return computedFactorials;
	}

	public BigInteger recursiveFactorial(BigInteger n) {
		if (n.equals(BigInteger.ZERO) || n.equals(BigInteger.ONE)) {
			return BigInteger.ONE;
		} else {
			return n.multiply(recursiveFactorial(n.subtract(BigInteger.ONE)));
		}
	}
}
