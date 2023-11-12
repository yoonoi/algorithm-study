package friday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Yy_1520_ {
	
	static int m, n;
	static int[][] board, dp;
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		board = new int[m+1][n+1];
		dp = new int[m+1][n+1];
		
		for(int i=1; i<=m; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=n; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				dp[i][j] = -1;
			}
		}
		
		System.out.println(dfs(1, 1));
	}
	
	static int dfs(int row, int col) {
		
		// 성공
		if(row == m && col == n) {
			return 1;
		}
		
		// 이미 방문한 경우
		if(dp[row][col] != -1) {
			return dp[row][col];
		}
		
		// 방문가넝함
		
		// 현재 위치에서 끝점까지 도달하는 경로의 개수를 0으로 초기화
		dp[row][col] = 0; 
		for(int i=0; i<4; i++) {
			int nr = row + dr[i];
			int nc = col + dc[i];
			
			if(isOutOfRange(nr, nc)) continue;
			
			if(isNotSmall(row, col, nr, nc)) continue;
			
			// 내려갈 수 있음
			// arr[x][y]보다 arr[nx][nr]이 더 낮아서 내려갈 수 있다면
			// arr[nx][ny]에서 끝점까지 도달하는 경로의 개수를 더한다.
			dp[row][col] += dfs(nr, nc);
		}
		
		return dp[row][col];
	}
	
	static boolean isOutOfRange(int row, int col) {
		return row < 1 || col < 1 || row > m || col > n;
	}
	
	static boolean isNotSmall(int nowR, int nowC, int nextR, int nextC) {
		return board[nowR][nowC] <= board[nextR][nextC];
	}

}
