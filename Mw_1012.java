package BOJ;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Mw_1012 {
	static int M, N, K; // 배추밭의 가로길이, 세로길이, 심어져 있는 배추의 개수
	static int[][] map; // 배추밭의 정보를 저장할 2차원 배열 map
	static boolean[][] visited; //방문 정보를 저장할 boolean 배열 visited
	
	static Queue<Point> q;
	
	static int[] dRow = {-1, 0, 1, 0}; // delta row
	static int[] dCol = {0, 1, 0, -1}; // delta col
	
	static int cnt = 0; // 필요한 지렁이의 수를 나타내는 변수 cnt
	
	static void search(int row, int col) {
		q = new LinkedList<Point>();
		int nRow, nCol;
		
		q.offer(new Point(row, col));
		visited[row][col] = true;
		
		while(!q.isEmpty()) {
			Point cur = q.poll();
			
			for(int idx = 0; idx < 4; idx++) {
				nRow = dRow[idx] + cur.x;
				nCol = dCol[idx] + cur.y;
				
				if(0 <= nRow && nRow < N && 0 <= nCol && nCol < M) {
					if(map[nRow][nCol] == 1 && !visited[nRow][nCol]) {
						visited[nRow][nCol] = true;
						q.offer(new Point(nRow, nCol));
					}
				}
			}
		}
		
		cnt++; // while문을 종료하면 cnt를 증가시킨다.
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt(); // 테스트 케이스의 개수를 나타내는 변수 T
		
		for(int tc= 0; tc < T; tc++) {
			M = sc.nextInt();
			N = sc.nextInt();
			
			map = new int[N][M];
			visited = new boolean[N][M];
			
			K = sc.nextInt();
			
			for(int idx = 0; idx < K; idx++) {
				int X = sc.nextInt();
				int Y = sc.nextInt();
				map[Y][X] = 1;
			}
			
			cnt = 0; // 메서드를 재 실행하기 전에 변수 cnt를 0으로 초기화 해준다.
			
			for(int row = 0; row < N; row++) {
				for(int col = 0; col < M; col++) {
					if(map[row][col] == 1 && !visited[row][col]) {
						search(row, col);
					}
				}
			}
			System.out.println(cnt);
		}
	}
}
