import java.util.Arrays;

public class Fibonacci {

	public static int fibonacciNaive(int i) {
		if (i == 0 || i == 1)
			return 1;
		return fibonacciNaive(i - 1) + fibonacciNaive(i - 2);
	}

	static int[] dp = new int[1000];
	static int[] dp2 = new int[1000];

	public static void init() {
		Arrays.fill(dp, -1);
		Arrays.fill(dp2, -1);

	}

	public static int fibonacciDp(int i) {

		dp[0] = dp[1] = 1;
		if (dp[i] != -1)
			return dp[i];
		return fibonacciDp(i - 1) + fibonacciDp(i - 2);

	}

	public static int fibonacciDp2(int i) {
		dp2[0] = dp2[1] = 1;

		for (int j = 2; j <= i; j++) {
			dp2[j] = dp2[j - 1] + dp2[j - 2];
		}
		return dp2[i];
	}

	public static void main(String[] args) {
		init();
		System.out.println(fibonacciNaive(10));
		System.out.println(fibonacciDp(10));
		System.out.println(fibonacciDp2(10));
	}

}
