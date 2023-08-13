import java.util.*;

public class Hw_11050_ {
	static int[][] dp;

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();

		dp = new int[N + 1][K + 1];
		System.out.println(method1(N, K));

	}

	public static int method1(int n, int k) {

		if (dp[n][k] > 0) {
			return dp[n][k];
		}
		if (n == k || k == 0) {
			return 1;
		}
		return dp[n][k] = method1(n - 1, k - 1) + method1(n - 1, k);
	}
}
