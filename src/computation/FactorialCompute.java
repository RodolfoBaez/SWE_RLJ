package computation;

public class FactorialCompute {

	public static int factorial(int n) {
		// Validate the input
		if (n < 0) {
			throw new IllegalArgumentException("Input must be a non-negative integer.");
		}

		// Base case for factorial
		if (n == 0) {
			return 1;
		} else {
			return n * factorial(n - 1);
		}
	}
}
