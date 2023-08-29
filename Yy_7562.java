package graph;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Yy_7562 {
	
	static StringTokenizer st;
	static int n, nowX, nowY, wantX, wantY;
	
	static int[][] visited; // 몇번 움직이는지 확인해야하니까 int 사용
	static int[] dr = {-2, -1, 1, 2, 2, 1, -1, -2};
	static int[] dc = {-1, -2, -2, -1, 1, 2, 2, 1};
	
	static void bfs(int nowX, int nowY, int wantX, int wantY) {
		if(nowX == wantX && nowY == wantY) {
			System.out.println(0);
			return;
		}
		
		Queue<Point> q = new LinkedList<>();
		
		q.offer(new Point(nowX, nowY));
		visited[nowX][nowY] = 0;
		
		while(!q.isEmpty()) {
			Point pop = q.poll();
			
			for(int i=0; i<8; i++) {
				int nextX = pop.x + dr[i];
				int nextY = pop.y + dc[i];
				
				if(nextX < 0 || nextY < 0 || nextX >= n || nextY >= n) continue;
				
				if(visited[nextX][nextY] != -1) continue;
				
				if(nextX == wantX && nextY == wantY) {
					System.out.println(visited[pop.x][pop.y] + 1);
					return; // 이거때문에 static 메서드로 밖에 빼줌
				}
				
				q.offer(new Point(nextX, nextY));
				visited[nextX][nextY] = visited[pop.x][pop.y] + 1; 
			}
		}		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=0; tc<T; tc++) {
			n = Integer.parseInt(br.readLine());
			visited = new int[n][n];
			for(int i=0; i<n; i++) {
				Arrays.fill(visited[i], -1);
			}
			
			st = new StringTokenizer(br.readLine());
			int nowX = Integer.parseInt(st.nextToken());
			int nowY = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			int wantX = Integer.parseInt(st.nextToken());
			int wantY = Integer.parseInt(st.nextToken());
			
			bfs(nowX, nowY, wantX, wantY);
		}
	}
}
