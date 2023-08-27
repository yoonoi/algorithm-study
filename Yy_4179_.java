package graph;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Yy_4179_ {

	static int r, c; 
	static char[][] map;
	static int[][] visited, fire;
	static Queue<Point> q = new LinkedList<>();
	static Queue<Point> fireQ = new LinkedList<>();
	
	static int[] dRow = {-1, 1, 0, 0};
	static int[] dCol = {0, 0, -1, 1};
	
	static boolean outOfRange(int row, int col) {
		return row < 0 || col < 0 || row >= r || col >= c;
	}
	
	static boolean isWall(int row, int col) {
		return map[row][col] == '#';
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map = new char[r][c];
		visited = new int[r][c];
		fire = new int[r][c];
		
		// 이걸안하면 시작점이 0으로 안남고 2가 된다.
		for(int i=0; i<r; i++) {
			Arrays.fill(fire[i], -1);
			Arrays.fill(visited[i], -1);
		}
		
		for(int i=0; i<r; i++) {
			String str = br.readLine();
			for(int j=0; j<c; j++) {
				map[i][j] = str.charAt(j);
				
				if(map[i][j] == 'J') {
					q.offer(new Point(i, j));
					visited[i][j] = 0;
				}
				
				if(map[i][j] == 'F') {
					fireQ.offer(new Point(i, j));
					fire[i][j] = 0;
				}
			}
		}

		while(!fireQ.isEmpty()) {
			Point pop = fireQ.poll();
			
			for(int i=0; i<4; i++) {
				int newRow = pop.x + dRow[i];
				int newCol = pop.y + dCol[i];
				
				if(outOfRange(newRow, newCol)) continue;
				
				if(isWall(newRow, newCol)) continue;
				
				if(fire[newRow][newCol] != -1) continue;
				
				fireQ.offer(new Point(newRow, newCol));
				fire[newRow][newCol] = fire[pop.x][pop.y] + 1;
			}
		}
		
		while(!q.isEmpty()) {
			Point pop = q.poll();
			
			for(int i=0; i<4; i++) {
				int newRow = pop.x + dRow[i];
				int newCol = pop.y + dCol[i];
				
				// 인덱스 범위를 넘어가면 탈출 성공한거니까 리턴
				if(outOfRange(newRow, newCol)) {
					System.out.println(visited[pop.x][pop.y] + 1);
					return;
				}
				
				if(isWall(newRow, newCol)) continue;
				
				if(visited[newRow][newCol] != -1) continue;
				
				// 불보다 느린지 체크하는거 추가
				// 여기에 fire[][] != -1을 꼭 추가해야 답이 안틀림 !!!
				// 불보다 느린지 체크할 때 불이 지나갔던 길보다 느려야만 못지나가니까! 
				if(fire[newRow][newCol] != -1 && fire[newRow][newCol] <= visited[pop.x][pop.y] + 1) continue;
				
				q.offer(new Point(newRow, newCol));
				visited[newRow][newCol] = visited[pop.x][pop.y] + 1;
			}
		}
		
		// 여기로왔으면 탈출 못한거니까 
		System.out.println("IMPOSSIBLE");
		
	}
}
