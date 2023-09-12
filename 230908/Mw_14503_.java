package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Mw_14503_ {
	
	static int n, m;
	static int[][] map;
	static int cnt = 0;
	
	static int[] dr = {0, 1, 0, -1}; // 동 남 서 북
	static int[] dc = {1, 0, -1, 0};
	
	static final int WALL = Integer.MAX_VALUE;
	
	static class Robot {
		
		int row;
		int col;
		int direction;
		
		public Robot(int row, int col, int direction) {
			this.row = row;
			this.col = col;
			this.direction = direction;
		}
	}
	
	static boolean outOfRange(int row, int col) {
		return row < 0 || col < 0 || row >= n || col >= m;
	}
	
	static boolean isWall(int row, int col) {
		return map[row][col] == WALL;
	}
	
	static boolean isClean(int row, int col) {
		return map[row][col] == 1;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		
		st = new StringTokenizer(br.readLine());
		int startRow = Integer.parseInt(st.nextToken());
		int startCol = Integer.parseInt(st.nextToken());
		int direction = (Integer.parseInt(st.nextToken()) + 3) % 4;
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				int input = Integer.parseInt(st.nextToken());
				
				// 벽일 떄 다르게 표시해주기
				if(input == 1) 
					map[i][j] = WALL;
			}
		}
		
		Queue<Robot> q = new LinkedList<Robot>();
		q.offer(new Robot(startRow, startCol, direction));
		
		while(!q.isEmpty()) {
			Robot now = q.poll();
			int nowRow = now.row;
			int nowCol = now.col;
			
			// 1. 현재칸이 아직 청소되지 않은 경우, 현재 칸을 청소한다.
			if(map[nowRow][nowCol] == 0) {
				map[nowRow][nowCol] = 1;
				cnt++;
			}
			
			boolean exist = false;
			for(int i=0; i<4; i++) {
				int nextRow = nowRow + dr[i];
				int nextCol = nowCol + dc[i];
				
				if(outOfRange(nextRow, nextCol)) continue;
				
				if(isWall(nextRow, nextCol)) continue;
				
				if(isClean(nextRow, nextCol)) continue;
				
				// 여기까지 왔으면 청소되지 않은 칸이 존재
				exist = true;	break;
			}
			
			// 청소할 칸이 없는 경우
			if(!exist) {
				// 방향을 유지한 채로 한칸 후진
				nowRow += dr[(direction + 2) % 4];
				nowCol += dc[(direction + 2) % 4];
				
				// 후진할 수 없다면 작동 중지
				// 벽일때도 후진할 수 없어서 벽일때 조건을 추가.(문제에 안써있음 ㅠㅠ)
				if(outOfRange(nowRow, nowCol) || isWall(nowRow, nowCol)) {
					System.out.println(cnt);
					return;
				}
				
				// 후진할 수 있을 때
				q.offer(new Robot(nowRow, nowCol, direction));
			}
			
			// 청소되지 않은 칸이 있는 경우
			if(exist) {
				// 반시계 방향으로 90도 회전
				direction = (direction + 3) % 4;
				
				// 바라보는 방향을 기준으로 앞쪽 칸이 청소되지 않은 빈 칸인 경우 한칸 전진
				int nextRow = nowRow + dr[direction];
				int nextCol = nowCol + dc[direction];
				
				if(!isWall(nextRow, nextCol) && !isClean(nextRow, nextCol))
					q.offer(new Robot(nextRow, nextCol, direction));
				else 
					q.offer(new Robot(nowRow, nowCol, direction));
			}
		}
	}
}