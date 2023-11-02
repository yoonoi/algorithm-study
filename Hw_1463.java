import java.util.*;

public class Hw_1463 {
	static int X;
	static int[] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		X = sc.nextInt();
		dp = new int[X + 1];
		for (int i = 1; i <= X; i++) {
			dp[i] = Integer.MAX_VALUE;
		}

		dp[X] = 0;
		for (int i = X; i > 0; i--) {
			if (i % 3 == 0) {
				dp[i / 3] = Math.min(dp[i / 3], dp[i] + 1);
			} 
			if (i % 2 == 0) {
				dp[i / 2] = Math.min(dp[i / 2], dp[i] + 1);
			}
			if (i - 1 > 0) {
				dp[i - 1] = Math.min(dp[i - 1], dp[i] + 1);
			}
		}
		System.out.println(dp[1]);
	}
}