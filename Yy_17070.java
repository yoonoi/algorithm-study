package bonus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Yy_17070 {

	static int n, cnt;
	static boolean[][] board;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		cnt = 0;
		
		board = new boolean[n][n];
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				if(st.nextToken().equals("1"))
					board[i][j] = true;
			}
		}
		
		dfs(0, 1, 0);
		System.out.println(cnt);
	}
	
	static void dfs(int row, int col, int direction) {
		
		if(row == n-1 && col == n-1) {
			cnt++;
			return;
		}
		
		// 가로
		if(direction == 0) {
			// 가로로 가든가
			if(goToGaro(row, col)) 
				dfs(row, col+1, 0);
			
			// 대각으로 가든가
			if(goToCross(row, col))
				dfs(row+1, col+1, 2);
		}
		
		// 세로
		if(direction == 1) {
			// 세로로 가든가
			if(goToSero(row, col)) 
				dfs(row+1, col, 1);
			
			// 대각으로 가든가
			if(goToCross(row, col)) 
				dfs(row+1, col+1, 2);
		}
		
		// 대각
		if(direction == 2) {
			// 가로
			if(goToGaro(row, col)) 
				dfs(row, col+1, 0);
			
			// 세로
			if(goToSero(row, col)) 
				dfs(row+1, col, 1);
			
			// 대각
			if(goToCross(row, col)) 
				dfs(row+1, col+1, 2);
		}
	}
	
	static boolean goToGaro(int row, int col) {
		if(col >= n-1) 
			return false;
		
		if(board[row][col+1]) 
			return false;
		
		return true;
	}
	
	static boolean goToSero(int row, int col) {
		if(row >= n-1) 
			return false;
		
		if(board[row+1][col]) 
			return false;
		
		return true;
	}
	
	static boolean goToCross(int row, int col) {
		if(row >= n-1 || col >= n-1) 
			return false;
		
		if(board[row][col+1] || board[row+1][col] || board[row+1][col+1]) 
			return false;
		
		return true;
	}
	
}
