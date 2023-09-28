package bonus;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Yy_2573빙산 {
	
	static int n, m;
	static int[][] board, visited;
	static int cnt; // 빙산의 덩어리 수 세기
	static final int INF = Integer.MIN_VALUE;
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		board = new int[n][m];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited = new int[n][m];
		changeYear(0);
	}
	
	static void bfs(int row, int col) {
		Queue<Point> q = new LinkedList<>();
		
		q.offer(new Point(row, col));
		visited[row][col] = board[row][col];
		
		while(!q.isEmpty()) {
			
			Point now = q.poll();
			
			for(int i=0; i<4; i++) {
				int nr = now.x + dr[i];
				int nc = now.y + dc[i];
				
				if(nr < 0 || nc < 0 || nr >= n || nc >= m) continue;
				
				if(visited[nr][nc] != INF) continue;
				
				// 바다면 카운트
				if(board[nr][nc] == 0 && visited[nr][nc] == INF) {
					visited[now.x][now.y]--;
					continue;
				}
				
				// 섬이면 큐에 넣어주기
				q.offer(new Point(nr, nc));
				visited[nr][nc] = board[nr][nc];
			}
			
			board[now.x][now.y] = visited[now.x][now.y] <= 0 ? 0 : visited[now.x][now.y];
		}
	}

	static void changeYear(int year) {
		cnt = 0;
		for(int i=0; i<n; i++)
			Arrays.fill(visited[i], INF);
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(board[i][j] != 0 && visited[i][j] == INF) {
					cnt++;
					
					if(cnt > 1) {
						System.out.println(year);
						return;
					}
					
					bfs(i, j);
				}
			}
		}

		if(cnt == 0)
			System.out.println(0);
		else 
			changeYear(year+1);
	}

}
