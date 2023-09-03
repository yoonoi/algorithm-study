package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Yy_2206_ {
	
	static class Node {
		int row;
		int col;
		int cnt;
		boolean broken;
		
		public Node(int row, int col, int cnt, boolean broken) {
			this.row = row;
			this.col = col;
			this.cnt = cnt;
			this.broken = broken;
		}
	}
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[][] map = new int[n][m];
		for(int i=0; i<n; i++) {
			String str = sc.next();
			for(int j=0; j<m; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		// 이렇게 해버리면 벽을 부수고 이동했을 때와, 벽을 부수지 않고 이동했을 때 경로가 겹쳐버려 진행이 불가
//		int[][] visited = new int[n][m];
		boolean[][][] visited = new boolean[n][m][2]; // 이렇게해서 부셨는지[1] 안부셨는지[0] 나눠서 넣어준다.
		
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(0, 0, 1, false));
		visited[0][0][0] = true;
		
		while(!q.isEmpty()) {
			Node now = q.poll();
			int r = now.row;
			int c = now.col;
			int cnt = now.cnt;
			boolean broken = now.broken;
			
			// 이거를 델타반복문에 넣어서 nr == n - 1 && nc == m - 1일떄로 놓으면 반례 (1 1 0)에서 -1이 출력되서 틀린다 중요중요!!
			if(r == n - 1 && c == m - 1) {
				System.out.println(cnt);
				return;
			}
			
			for(int i=0; i<4; i++) {
				int nr = r + dr[i];
				int nc = c + dc[i];
				
				if(nr < 0 || nc < 0 || nr >= n || nc >= m) continue;
				
				// 1. 벽일 때
				if(map[nr][nc] == 1) {
					// 벽을 부순적이 없고 방문경험이 없어야 방문 가능
					if(!broken) {
						q.offer(new Node(nr, nc, cnt+1, true));
						visited[nr][nc][1] = true;
					}
				}
				// 2. 벽이 아닐 때 - 벽을 부순 여부에 따라 방문 체크
				else {
					// 1. 벽을 부순적이 있는지
					if(broken && !visited[nr][nc][1]) {
						q.offer(new Node(nr, nc, cnt+1, true));
						visited[nr][nc][1] = true;
					} 
					// 2. 벽을 부순적이 없는지
					else if(!broken && !visited[nr][nc][0]) {
						q.offer(new Node(nr, nc, cnt+1, false));
						visited[nr][nc][0] = true;
					}
				}
			}
		}
		
		System.out.println(-1);
		
	}
}
