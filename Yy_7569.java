package graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Yy_7569 {
	
	// 델타배열이 3개필요
	static int[] dr = {-1, 1, 0, 0, 0, 0}; // 상하좌우 위아래
	static int[] dc = {0, 0, -1, 1, 0, 0};
	static int[] dh = {0, 0, 0, 0, -1, 1};
	
	static int[][][] map, visited;
	static int m, n, h; // 가로세로높이
	static int days = -1; // 답
	
	static Queue<Coordinate> q = new LinkedList<>();
	
	static class Coordinate {
		
		int x, y, z;
		
		public Coordinate(int x, int y, int z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		n = sc.nextInt();
		h = sc.nextInt();
		
		map = new int[n][m][h];
		visited = new int[n][m][h];

		// 입력받느게어렵구만
		for(int i=0; i<h; i++) {
			for(int j=0; j<n; j++) {
				for(int k=0; k<m; k++) {
					map[j][k][i] = sc.nextInt();
					
					// 익은 토마토인 위치 다 큐에 넣어주기
					if(map[j][k][i] == 1) {
						q.offer(new Coordinate(j, k, i));
						visited[j][k][i] = 0;
					}
					
					// 안익은 토마토만 방문배열 초기화
					if(map[j][k][i] == 0) {
						visited[j][k][i] = -1;
					}
				}
			}
		}
		
		while(!q.isEmpty()) {
			Coordinate pop = q.poll();
			
			for(int i=0; i<6; i++) {
				int nextX = pop.x + dr[i];
				int nextY = pop.y + dc[i];
				int nextZ = pop.z + dh[i];
				
				if(nextX < 0 || nextY < 0 || nextZ < 0 || nextX >= n || nextY >= m || nextZ >= h) continue;
				
				if(visited[nextX][nextY][nextZ] != -1) continue;
				
				if(map[nextX][nextY][nextZ] != 0) continue;
				
				q.offer(new Coordinate(nextX, nextY, nextZ));
				visited[nextX][nextY][nextZ] = visited[pop.x][pop.y][pop.z] + 1; 
			}
		}
		
		
		
//		for(int i=0; i<h; i++) {
//			for(int j=0; j<n; j++) {
//				for(int k=0; k<m; k++) {
//					System.out.print(visited[j][k][i] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println("==========");
//		}
		
		for(int i=0; i<h; i++) {
			for(int j=0; j<n; j++) {
				for(int k=0; k<m; k++) {
					if(visited[j][k][i] == -1) {
						System.out.println(-1);
						return;
					}
					
					if(visited[j][k][i] > days) {
						days = visited[j][k][i];
					}
				}
			}
		}

		
		System.out.println(days);
		
	}

}
