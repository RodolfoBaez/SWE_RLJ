package computation;

public class FactorialCompute {

	public static int factorial(int n) {
		// Validate that the parameter is non-negative
		if (n < 0) {
			throw new IllegalArgumentException("Parameter n must be non-negative. Provided: " + n);
		}

		// Validate that n does not exceed 20 to prevent overflow
		if (n > 20) {
			throw new IllegalArgumentException("Parameter n is too large. Factorial may overflow for n > 20. Provided: " + n);
		}

		if (n == 0) {
			return 1;
		} else {
			return n * factorial(n - 1);
		}
	}
}
