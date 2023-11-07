package silver;

import java.util.Scanner;

public class Kh_1912 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		int[] seq = new int[n];

		for (int i = 0; i < n; i++) {
			seq[i] = sc.nextInt();
		}

		int[] dp = new int[n];
		dp[0] = seq[0];
		for (int i = 1; i < n; i++) {
			dp[i] = Math.max(dp[i - 1] + seq[i], seq[i]);
		}

		int max = Integer.MIN_VALUE;

		for (int i = 0; i < n; i++) {
			max = Math.max(max, dp[i]);
		}
		
		System.out.println(max);
	}

}
