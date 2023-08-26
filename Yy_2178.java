package graph;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 미로 탐색
public class Yy_2178 {
	
	static int n, m;
	static boolean[][] map;
	static int[] dRow = {-1, 1, 0, 0};
	static int[] dCol = {0, 0, -1, 1};
	static Queue<Point> q = new LinkedList<Point>();
	static int[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new boolean[n][m];
		visited = new int[n][m];
		
		for(int i=0; i<n; i++) {
			String input = br.readLine();
			for(int j=0; j<m; j++) {
				if(input.charAt(j) == '1') map[i][j] = true;
			}
		}
		
		q.offer(new Point(0, 0));
		visited[0][0] = 1;
		
		while(!q.isEmpty()) {
			Point pop = q.poll();
			
			for(int k=0; k<4; k++) {
				int newRow = pop.x + dRow[k];
				int newCol = pop.y + dCol[k];
				
				if(newRow < 0 || newCol < 0 || newRow >= n || newCol >= m) continue;
				
				if(!map[newRow][newCol]) continue;
				
				if(visited[newRow][newCol] != 0) continue;
				
				q.offer(new Point(newRow, newCol));
				visited[newRow][newCol] = visited[pop.x][pop.y] + 1; 
			}
		}
		
		System.out.println(visited[n-1][m-1]);
	}
}
