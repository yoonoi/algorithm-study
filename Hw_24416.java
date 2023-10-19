import java.util.*;

public class Hw_24416 {
	static int recurCount = 0;
	static int dpCount = 0;
	static int[] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		dp = new int[N + 1];
		dp[1] = 1;
		dp[2] = 1;
		for (int i = 3; i <= N; i++) {
			dpCount++;
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		fib(N);
		System.out.println(recurCount + " " + dpCount);

	}

	static int fib(int n) {
		if (n == 1 || n == 2) {
			recurCount++;
			return 1;
		} else {
			return (fib(n - 1) + fib(n - 2));
		}
	}

}
