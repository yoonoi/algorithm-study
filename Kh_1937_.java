package gold;

import java.util.Scanner;

public class Kh_1937_ {
	static int N;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int[][] bamboo;
	static int[][] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		bamboo = new int[N][N];
		dp = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				bamboo[i][j] = sc.nextInt();
			}
		}
		
		int answer = 0;
		
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < N ; j++) {
				answer = Math.max(answer, dfs(i,j));
			}
		}
		System.out.println(answer);
		sc.close();
	}
	
	public static int dfs(int r, int c) {
		if(dp[r][c] != 0 ) {
			return dp[r][c];
		}
		dp[r][c] = 1;
		
		for(int d=0 ; d <4 ; d++) {
			int nr = r+dr[d];
			int nc = c+dc[d];
			
			if(nr < 0 || nc < 0 || nr >= N || nc >= N) {
				continue;
			}
			
			if(bamboo[r][c] < bamboo[nr][nc]) {
				dp[r][c] = Math.max(dp[r][c], dfs(nr, nc)+1);
//				dfs(nr, nc);
			}
		}
		return dp[r][c];
		
	}

}
