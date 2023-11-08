package silver;

import java.util.Scanner;

public class Kh_1149_ {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[][] rgb = new int[N][3];

		for (int i = 0; i < N; i++) {
			rgb[i][0] = sc.nextInt();
			rgb[i][1] = sc.nextInt();
			rgb[i][2] = sc.nextInt();
		}
		// 0=r 1=g 2=b
		int[][] dp = new int[N][3];
		// dp[n][0] = min(dp[n-1][1],dp[n-1][2])+ + rgb[n][0]
		for (int i = 0; i < 3; i++) {
			dp[0][i] = rgb[0][i];
		}
		for (int n = 1; n < N; n++) {
			for (int i = 0; i < 3; i++) {
				dp[n][i] = rgb[n][i] + Math.min(dp[n-1][(i+1)%3], dp[n-1][(i+2)%3]);
			}
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < 3; i++) {
			min = Math.min(min, dp[N-1][i]);
		}
		System.out.println(min);
	}

}
