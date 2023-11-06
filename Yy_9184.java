package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Yy_9184 {

	static int[][][] dp = new int[21][21][21];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		makeDp();
		while(true) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			if(a == -1 && b == -1 && c == -1)
				return;
			
			System.out.println(print(a, b, c));
		}
		
	}
	
	static void makeDp() {
		
		for(int i=0; i<=20; i++) {
			for(int j=0; j<=20; j++) {
				for(int k=0; k<=20; k++) {
					if(i == 0 || j == 0 || k == 0)
						dp[i][j][k] = 1;
					
					else if(i < j && j < k)
						dp[i][j][k] = dp[i][j][k-1] + dp[i][j-1][k-1] - dp[i][j-1][k];
					
					else
						dp[i][j][k] = dp[i-1][j][k] + dp[i-1][j-1][k] + dp[i-1][j][k-1] - dp[i-1][j-1][k-1];
				}
			}
		}
	}
	
	static String print(int a, int b, int c) {
		StringBuilder sb = new StringBuilder("w(");
		sb.append(a).append(", ").append(b).append(", ").append(c).append(") = ");

		// 아래 순서처럼 쓰면 w(-1, 30, -1)이런 경우에 위에게 먼저 적용되서 틀림!!!!!
//		if(a > 20 || b > 20 || c > 20)
//			sb.append(dp[20][20][20]);
//		
//		else if(a <= 0 || b <= 0 || c <= 0)
//			sb.append(1);
		
		if(a <= 0 || b <= 0 || c <= 0)
			sb.append(1);
		else if(a > 20 || b > 20 || c > 20)
			sb.append(dp[20][20][20]);
		else
			sb.append(dp[a][b][c]);
		
		return sb.toString();
	}

}
