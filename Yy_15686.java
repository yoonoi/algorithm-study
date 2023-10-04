package bonus.retry;

import java.awt.Point;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Yy_15686 {

	static int n, m, ans;
	static int[][] board;
	static List<Point> chickens; // 치킨집 전체 저장 후 그 중 m개 골라야함
	static int[] selected;
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		board = new int[n][n];
		
		chickens = new ArrayList<>();
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				board[i][j] = sc.nextInt();
				
				if(board[i][j] == 2)
					chickens.add(new Point(i, j));
			}
		}
		
		selected = new int[m];
		ans = Integer.MAX_VALUE;
		
		combination(0, 0);
		System.out.println(ans);
	}
	
	// 조합
	static void combination(int idx, int sIdx) {
		// 치킨집중에 m개 고른거
		if(sIdx == m) {
			Queue<Point> q = new LinkedList<>();
			int[][] visited = new int[n][n];
			
			for(int i=0; i<m; i++) {
				Point select = chickens.get(selected[i]);
				
				q.offer(select);
				visited[select.x][select.y] = 1; 
			}
			
			bfs(q, visited);
			return;
		}
		
		if(idx == chickens.size()) return;
		
		selected[sIdx] = idx;
		combination(idx+1, sIdx+1);
		combination(idx+1, sIdx);
	}
	
	static void bfs(Queue<Point> q, int[][] visited) {
		
		int cnt = 0;
		
		while(!q.isEmpty()) {
			Point now = q.poll();
			
			for(int i=0; i<4; i++) {
				int nr = now.x + dr[i];
				int nc = now.y + dc[i];
				
				if(nr < 0 || nc < 0 || nr >= n || nc >= n) continue;
				
				if(visited[nr][nc] != 0) continue;
				
				visited[nr][nc] = visited[now.x][now.y]+ 1; 
				q.offer(new Point(nr, nc));
				
				// 가정집이면 치킨거리 구하기
				if(board[nr][nc] == 1) {
					cnt += visited[nr][nc] - 1;
				}
			}
		}
		
		if(ans > cnt)
			ans = cnt;
	}
}
