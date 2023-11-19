package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://iseunghan.tistory.com/343
public class Mw_10844_ {
	
	static int n;
	static long[][] dp; // 길이가 i이고, j로 시작하는 수들 중 계단수의 개수
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		dp = new long[n+1][10];
		
		for(int i=0; i<=9; i++) 
			dp[1][i] = 1;
		
		for(int i=2; i<=n; i++) {
			// 0으로 시작하는 수 = 이전길이의 1로 시작하는 수
			dp[i][0] = dp[i-1][1];
			
			// 1 ~ 8로 시작하는 수 = 이전길이의 j-1 + j+1
			for(int j=1; j<=8; j++) 
				dp[i][j] = (dp[i-1][j-1] + dp[i-1][j+1]) % 1000000000;
			
			// 9로 시작하는 수 = 이전길이의 8로 시작하는 수
			dp[i][9] = dp[i-1][8];
		}
		
		long result = 0;
		for(int i=1; i<=9; i++) {
			result += dp[n][i];
		}
		
		System.out.println(result % 1000000000);
	}
	

}