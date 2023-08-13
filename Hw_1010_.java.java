import java.util.*;

public class Hw_1010_ {
	static int[][] dp = new int[30][30];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int testCase = sc.nextInt();
		for (int tc = 1; tc <= testCase; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();

			System.out.println(combine(M, N));
		}
	}

	public static int combine(int n, int r) {
		if (dp[n][r] > 0) {
			return dp[n][r];
		}
		if (n == r || r == 0) {
			return 1;
		}
		return dp[n][r] = combine(n - 1, r - 1) + combine(n - 1, r);
	}
}
