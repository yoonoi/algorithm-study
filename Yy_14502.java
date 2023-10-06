package bonus;

import java.awt.Point;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;


/*
 * 빈칸을 만나면,
 *  벽을 세운 후 벽 카운트를 늘리고, 다시 빈칸을 찾는다.
 * 
 * 벽이 3개가 세워지면 bfs를 시작해서 안전 영역을 체크한 후 return한다.
 * 
 * 벽 세웠떤 걸 다시 무너뜨리고 다음칸으로 넘어간다.
 * 
 */
public class Yy_14502 {
	
	static int n, m;
	static int[][] board;
	static int safezone = 0;
	static int ans = Integer.MIN_VALUE;
	
	static boolean[][] visited;
	
	static List<Point> virusPoints;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		board = new int[n][m];
		
		virusPoints = new ArrayList<>();
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				board[i][j] = sc.nextInt();
				
				if(board[i][j] == 2)
					virusPoints.add(new Point(i, j));
				
				if(board[i][j] == 0)
					safezone++;
			}
		}
		
		safezone -= 3; // 벽 세울거니까 미리 빼주고 시작.
		visited = new boolean[n][m];
		
		checkBoard(0, 0);
		System.out.println(ans);
	}
	
	
	static void checkBoard(int row, int walls) {
		if(walls == 3) {
			int tmpCnt = sumOfVirus();
			
			ans = Math.max(tmpCnt, ans);
			return;
		}
		
		for(int i=row; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(board[i][j] != 0) continue;
				
				// 빈칸이면서, 방문한적 없으면
				if(!visited[i][j]) {
					board[i][j] = 1;
					visited[i][j] = true;
					
					checkBoard(i, walls+1);
					
					board[i][j] = 0;
					visited[i][j] = false;
				}
			}
		}
	}
	
	// bfs
	static int sumOfVirus() {
		int cnt = 0;
		
		Queue<Point> q = new LinkedList<>();
		boolean[][] visited = new boolean[n][m];
		
		for(Point virus : virusPoints) {
			q.offer(virus);
			visited[virus.x][virus.y]= true; 
		}
		
		while(!q.isEmpty()) {
			Point now = q.poll();
			
			for(int i=0; i<4; i++) {
				int nr = now.x + dr[i];
				int nc = now.y + dc[i];
				
				if(nr < 0 || nc < 0 || nr >= n || nc >= m) continue;
				
				if(visited[nr][nc]) continue;
				
				if(board[nr][nc] != 0) continue;
				
				visited[nr][nc] = true;
				q.offer(new Point(nr, nc));
				cnt++;
			}
		}
		
		return safezone - cnt;
	}
}
