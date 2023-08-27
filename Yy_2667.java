package graph;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Yy_2667 {
	
	static int n;
	static boolean[][] map;
	static StringBuilder sb = new StringBuilder();
	static int[][] visited;
	static Queue<Point> q = new LinkedList<>();
	static int[] dRow = {-1, 1, 0, 0};
	static int[] dCol = {0, 0, -1, 1};
	static PriorityQueue<Integer> pq = new PriorityQueue<>();
	
	static void bfs(int row, int col) {
		q.offer(new Point(row, col));
		visited[row][col] = 1;
		int cnt = 1; // 단지 수
		
		while(!q.isEmpty()) {
			Point pop = q.poll();
			
			for(int i=0; i<4; i++) {
				int newRow = pop.x + dRow[i];
				int newCol = pop.y + dCol[i];
				
				// 인덱스 범위 넘어가거나
				if(outOfRange(newRow, newCol)) continue;
				
				// 집이 없거나
				if(!map[newRow][newCol]) continue;
				
				// 방문을 이미 했으면 패스
				if(visited[newRow][newCol] != 0) continue;
				
				q.offer(new Point(newRow, newCol));
				visited[newRow][newCol] = visited[pop.x][pop.y] + 1;
				cnt += 1;
			}
		}
		
		pq.offer(cnt);
	}
	
	static boolean outOfRange(int row, int col) {
		return row < 0 || col < 0 || row >= n || col >= n;
	}
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		map = new boolean[n][n];
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			for(int j=0; j<n; j++) {
				if(str.charAt(j) == '1')
					map[i][j] = true;
			}
		}
		
		visited = new int[n][n];
	}
	
	public static void main(String[] args) throws IOException {
		input();
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j] && visited[i][j] == 0) {
					bfs(i, j);
				}
			}
		}
		
		sb.append(pq.size()).append("\n");
		while(!pq.isEmpty()) {
			sb.append(pq.poll()).append("\n");
		}
		
		System.out.println(sb);
	}
}
