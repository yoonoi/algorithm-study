package bonus.retry;

import java.util.Scanner;

public class Yy_14503 { 
	
	static int n, m;
	static int[][] board;
	static int ans = 0;
	static boolean[][] cleaned;
	
	// 동 서 헷갈리지 말자 ^^... 개고생했네
	static final int[] dr = {-1, 0, 1, 0}; // 북 동 남 서
	static final int[] dc = {0, 1, 0, -1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		board = new int[n][m];
		cleaned = new boolean[n][m];
		
		int startRow = sc.nextInt();
		int startCol = sc.nextInt();
		int startDirection = sc.nextInt();
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				board[i][j] = sc.nextInt();
				
				if(board[i][j] == 1)
					cleaned[i][j] = true;
			}
		}
		
		cleanMyRoom(startRow, startCol, startDirection);
	}
	
	static void cleanMyRoom(int row, int col, int direction) {
		
		// 현재칸이 청소안되어있으면 현재 칸 청소
		if(!cleaned[row][col]) {
			cleaned[row][col] = true;
			ans++;
		}
		
		boolean exist = false;
		// 현재칸의 주변 4칸 중 청소되지 않은 빈칸 찾기
		for(int i=0; i<4; i++) {
			int nr = row + dr[i];
			int nc = col + dc[i];
			
			if(isOutOfRange(nr, nc)) continue;
			
			if(isCleaned(nr, nc)) continue;
			
			// 여기까지 왔으면 청소할 칸이 있는거
			exist = true;
			break;
		}
		
		// 청소되지 않은 빈칸이 있는 경우
		if(exist) {
			// 반시계 방향으로 90도 회전
			direction = turn(direction);
			
			int nextRow = row + dr[direction];
			int nextCol = col + dc[direction];
			
			// 바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈칸인 경우 한칸 전진
			if(!isCleaned(nextRow, nextCol)) {
				row = nextRow;
				col = nextCol;
			}
		}
		// 빈칸이 없는 경우
		else {
			// 후진할 자리
			row += dr[(direction + 2) % 4];
			col += dc[(direction + 2) % 4];
			
			// 후진할 수 없다면 작동을 멈춤
			if(isOutOfRange(row, col) || isWall(row, col)) {
				System.out.println(ans);
				return;
			}
		}
		
		cleanMyRoom(row, col, direction);
	}
	
	// 반시계 방향으로 90도 회전
	static int turn(int direction) {
		// 위 -> 왼 0 -> 3
		// 왼 -> 아 3 -> 2
		// 아 -> 오 2 -> 1
		// 오 -> 위 1 -> 0
		
		direction += 3;
		direction %= 4;
		
		return direction;
	}
	
	static boolean isOutOfRange(int row, int col) {
		return row < 0 || col < 0 || row >= n || col >= m;
	}
	
	static boolean isWall(int row, int col) {
		return board[row][col] == 1;
	}
	
	static boolean isCleaned(int row, int col) {
		return cleaned[row][col];
	}

}
