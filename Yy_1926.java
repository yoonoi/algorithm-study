package graph;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Yy_1926 {
	
	static int n, m; // 세로, 가로
	static int[][] map;
	static int[][] visited; 
	
	static int[] dx = {-1, 1, 0, 0}; // 상하좌우
	static int[] dy = {0, 0, -1, 1};
	
	static Queue<Point> q = new LinkedList<>();
	
	static int cnt = 0; // 그림 개수
	static int maxArea = 0; // 최대 넓이
	static int tmp;
	
	static void bfs(int row, int col) {
		
		visited[row][col] = tmp++;
		q.offer(new Point(row, col));
		
		while(!q.isEmpty()) {
			
			Point pop = q.poll();
			
			for(int i=0; i<4; i++) {
				int nextRow = pop.x + dx[i];
				int nextCol = pop.y + dy[i];
				
				// 범위 넘어가면 패스
				if(nextRow < 0 || nextCol < 0 || nextRow >=n || nextCol >=m) continue;
				
				// 이미 방문했어도 패스
				if(visited[nextRow][nextCol] != 0) continue;
				
				// 방문 불가능하면 패스
				if(map[nextRow][nextCol] == 0) continue;
				
				// 여기까지오면 방문 가넝하니 방문해준다.
				q.offer(new Point(nextRow, nextCol));
				visited[nextRow][nextCol] = tmp++;
			}
		}
		
		if(maxArea < tmp) {
			maxArea = tmp;
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		visited = new int[n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j] == 1 && visited[i][j] == 0) {
					cnt++;
					tmp = 1;
					bfs(i, j);
				}
			}
		}
		
//		for(int i=0; i<n; i++) {
//			for(int j=0; j<m; j++) {
//				System.out.print(visited[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		System.out.println(cnt);
		System.out.println(cnt == 0 ? 0 : maxArea - 1);
	}

}
