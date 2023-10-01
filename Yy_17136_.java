package bonus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 큰 종이부터 붙이는 그리디적인 사고를 이용하되,
 * DFS와 백트래킹을 사용하여 완전탐색을 수행해야함!
 * 일단 size X size 범위 내 모두 1이라면 size크기 색종이를 붙였다가 뗐다가 반복함.
 */
public class Yy_17136_ {
	
	static int[][] board = new int[10][10];
	static int[] papers = {0, 5, 5, 5, 5, 5};
	static int ans = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for(int i=0; i<10; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<10; j++) {
				if(st.nextToken().equals("1"))
					board[i][j] = 1;
			}
		}
		
		dfs(0, 0, 0);
		
		if(ans == Integer.MAX_VALUE)
			ans = -1;
		
		System.out.println(ans);
	}
	
	// dfs + 백트래킹
	static void dfs(int row, int col, int cnt) {
		
		// 맨 끝점에 도달했을 경우
		if(row >= 9 && col > 9) {
			// ans와 cnt 비교 후 종료
			ans = Math.min(ans, cnt);
			return;
		}
		
		// 최솟값을 구해야하는데 ans보다 cnt가 커지면 더이상 탐색할 필요가 없으니 종료
		if(ans <= cnt)
			return;
		
		// 아래줄로 이동
		if(col > 9) {
			dfs(row + 1, 0, cnt);
			return;
		}
		
		// 색종이를 붙일 수 있으면
		if(board[row][col] == 1) {
			// 큰 색종이부터 확인해서
			for(int i=5; i>=1; i--) {
				if(papers[i] > 0 && canAttach(row, col, i)) {
					attach(row, col, i, 0); // 색종이를 붙임
					papers[i]--;
					
					dfs(row, col+i, cnt+1); // 붙였으니까 cnt+1하고 i칸 옆으로 이동
					
					attach(row, col, i, 1); // 색종이를 다시 뗌
					papers[i]++;
				}
			}
		} 
		// 색종이를 붙일 수 없으면
		else {
			// 오른쪽으로 이동
			dfs(row, col+1, cnt);
		}
		
	}
	
	// 색종이를 붙일 수 있는지 체크
	static boolean canAttach(int row, int col, int size) {
		if(row+size > 10 || col+size > 10)
			return false;
		
		for(int i=row; i<row+size; i++) {
			for(int j=col; j<col+size; j++) {
				if(board[i][j] != 1)
					return false;
			}
		}
		
		return true;
	}
	
	/**
	 * 색종이를 붙이는 함수
	 * @param row 행
	 * @param col 열
	 * @param size 색종이 크기
	 * @param state 0이면 임시로 붙이기(0을 해서 다른애들이 못붙이게 함), 1이면 다시 원래대로 돌려놓기
	 */
	static void attach(int row, int col, int size, int state) {
		for(int i=row; i<row+size; i++) {
			for(int j=col; j<col+size; j++) {
				board[i][j] = state;
			}
		}
	}
}
