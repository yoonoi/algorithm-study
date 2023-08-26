package graph;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Yy_7576_ {
	
	static int m, n;
	static int[][] map, visited;
	static int[] dRow = {-1, 1, 0, 0};
	static int[] dCol = {0, 0, -1, 1};
	static Queue<Point> q = new LinkedList<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visited = new int[n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				// 인풋을 받으면서 익은 토마토가 있는 위치를 미리 큐에 넣어준다!!
				if(map[i][j] == 1) 
					q.offer(new Point(i, j));
				
				// 토마토가 안익은 부분만 방문확인을 위해 visited배열 초기화
				if(map[i][j] == 0)
					visited[i][j] = -1;
			}
		}

		while(!q.isEmpty()) {
			Point pop = q.poll();
			
			for(int i=0; i<4; i++) {
				int newRow = pop.x + dRow[i];
				int newCol = pop.y + dCol[i];
				
				if(newRow < 0 || newCol < 0 || newRow >=n || newCol >= m) continue;
				
				if(map[newRow][newCol] != 0) continue;
				
				if(visited[newRow][newCol] != -1) continue;
				
				q.offer(new Point(newRow, newCol));
				visited[newRow][newCol] = visited[pop.x][pop.y] + 1;
			}
		}
		
		int days = -1;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(visited[i][j] == -1) {
					System.out.println(-1);
					return;
				}
				
				if(days < visited[i][j])
					days = visited[i][j];
			}
		}
		
		System.out.println(days);
	}
}
