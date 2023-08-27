package BOJ;

import java.util.*;
import java.awt.*;

public class Mw_1926 {
	static int n, m; // 가로와 세로를 나타내는 변수 n과 m
	static int[][] board; // 그림을 나타내는 2차원 배열 board
	static boolean[][] visited; // 방문 여부를 나타내는 2차원 배열 visited
	static int[] dr = {-1, 0, 1, 0}; // delta row (위에서 부터 시계방향으로)
	static int[] dc = {0, 1, 0, -1}; // delta col (위에서 부터 시계방향으로)
	
	static Queue<Point> q = new LinkedList<>(); // 큐 

	static int cnt = 0; // 그림의 개수를 나타내는 변수
	static int maxArea = 0; // 최대 넓이를 나타내는 변수
	static int area; // 그림의 넓이를 저장할 변수
	
	static void bfs(int row, int col) {
		visited[row][col] = true; // 해당 배열을 방문한 것으로 처리한다.
		area++; // 넓이를 증가시킨다.
		q.offer(new Point(row, col)); // 해당 배열을 큐에 입력한다.
		
		while(!q.isEmpty()) { // 큐가 빈 큐가 될 때까지 while문을 실행한다.
			
			Point index = q.poll(); // index는 큐 가장 앞에 있는 배열의 인덱스 값.
			
			for(int idx = 0; idx < 4; idx++) { // 반복문을 통해 사방향 탐색을 하자.
				int nRow = index.x + dr[idx]; // 다음 row 배열
				int nCol = index.y + dc[idx]; // 다음 col 배열
			
				if(nRow < 0 || nRow >= n || nCol < 0 || nCol >= m) continue; // 범위를 넘어가거나,
				
				if(board[nRow][nCol] == 0) continue; // 방문할 수 없거나,
				
				if(visited[nRow][nCol]) continue; // 이미 방문한 배열이라면 넘기고,
				
				q.offer(new Point(nRow, nCol)); // 그게 아니라면, 해당 배열의 인덱스를 큐에 삽입하자.
				visited[nRow][nCol] = true; // 방문 처리도 하고
				area++; // 넓이도 증가 시켜주자
				
			}
		}
		
		maxArea = Math.max(maxArea, area); // Math.max 메서드를 통해 maxArea에 최대값을 저장한다.
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		board = new int[n][m];
		visited = new boolean[n][m];
		
		for(int row = 0; row < n; row++) {
			for(int col = 0; col < m; col++) {
				board[row][col] = sc.nextInt();
			}
		}
		
		for(int row = 0; row < n; row++) {
			for(int col = 0; col < m; col++) {
				if(board[row][col] == 1 && !visited[row][col]) {
					cnt++; // 조건이 맞을 때 마다 cnt를 증가시킨다.
					area = 0;
					bfs(row, col);
				}
			}
		}
		
		System.out.println(cnt);
		System.out.println(cnt == 0 ? 0 : maxArea); // 삼항 연산자를 이용해 최대 넓이를 출력하자.
	}
}
