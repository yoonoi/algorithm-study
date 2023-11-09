package silver;

import java.util.Scanner;

public class Kh_1932 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int max = 0;
		int[][] triangle = new int[n][n];
		for(int i = 0 ; i < n ; i++) {
			for(int j = 0 ; j <= i ; j++) {
				triangle[i][j]=sc.nextInt();
			}
		}
		
		int[][] dp = new int[n][n];
		dp[0][0] = triangle[0][0];
		if(n==1) {
			System.out.println(dp[0][0]);
			return;
		}
		dp[1][0] = dp[0][0]+ triangle[1][0];
		dp[1][1] = dp[0][0]+ triangle[1][1];
		if(n ==2) {
			max = Math.max(dp[1][0], dp[1][1]);
			System.out.println(max);
			return;
		}
		
		for(int i = 2; i < n ; i++) {
			dp[i][0] = dp[i-1][0]+triangle[i][0];
			dp[i][i] = dp[i-1][i-1]+triangle[i][i];

			for(int j = 1 ; j < i ; j++) {
				dp[i][j]=triangle[i][j] + Math.max(dp[i-1][j-1], dp[i-1][j]);
			}
		}
		
		for(int i = 0 ; i < n ; i++) {
			max = Math.max(max, dp[n-1][i]);
		}

		System.out.println(max);
	}

}
