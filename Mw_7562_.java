package BOJ;

import java.awt.Point;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Mw_7562_ {
	
	static int n, nowX, nowY, wantX, wantY;
	static int[][] visited; // 몇번 움직이는지 횟수를 확인해야하니까 int배열 사용
	
	// 이 문제에선 상하좌우가 아니라 8가지 위치를 확인하기때문에 델타배열이 아래처럼 사용된다.
	static int[] dr = {-2, -1, 1, 2, 2, 1, -1, -2};
	static int[] dc = {-1, -2, -2, -1, 1, 2, 2, 1};
	
	static void bfs(int nowX, int nowY, int wantX, int wantY) {
		// 시작부터 시작점과 희망위치가 같다면 끝내버리기
		if(nowX == wantX && nowY == wantY) {
			System.out.println(0);
			return;
		}
		
		// 시작점 != 희망위치라면 bfs를 돌려준다. 
		// bfs를 위한 q 생성
		Queue<Point> q = new LinkedList<>();
		
		// bfs의 시작 : 시작점 큐에넣고 방문표시하기!!!!!!! 중요중요 외워외워
		q.offer(new Point(nowX, nowY));
		visited[nowX][nowY] = 0; // 0부터 시작!
		
		while(!q.isEmpty()) {
			// 제일먼저 큐에 들어간 점 뺴버리고
			Point pop = q.poll();
			
			// 델타배열 돌리면서 1번이동 후 점들(다음 차례 점들) 확인
			for(int i=0; i<8; i++) {
				int nextX = pop.x + dr[i];
				int nextY = pop.y + dc[i];
				
				// 인덱스 범위 넘어가면 패스
				if(nextX < 0 || nextY < 0 || nextX >= n || nextY >= n) continue;
				
				// 방문전적 있으면 패스
				if(visited[nextX][nextY] != -1) continue;
				
				// 만약 희망 위치와 같다면 출력 후 종료해버리기
				if(nextX == wantX && nextY == wantY) {
					System.out.println(visited[pop.x][pop.y] + 1);
					return; // 여기서 리턴을 사용하기 위해 main메서드 안에 작성하지 않고 static 메서드로 작성했다. (이해안되면 질문)
				}
				
				// 여기까지 왔으면 희망위치에 도달하지 못했고, 방문도 가능하니
				// 큐에 넣어주고 방문표시 해주기! 
				// 방문표시는 현재 위치 + 1로 해주깅
				q.offer(new Point(nextX, nextY));
				visited[nextX][nextY] = visited[pop.x][pop.y] + 1; 
			}
		}		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=0; tc<T; tc++) {
			n = sc.nextInt(); // 이 문제에서는 map을 따로 만들 필요가 없다! 
			visited = new int[n][n];
			
			for(int i=0; i<n; i++) {
				Arrays.fill(visited[i], -1);
			}
			// 위의 Arrays.fill 반복문은 아래와 동일한 코드임(참고)
//			for(int i=0; i<n; i++) {
//				for(int j=0; j<n; j++) {
//					visited[i][j] = -1;
//				}
//			}
			
			// 현재 좌표
			int nowX = sc.nextInt();
			int nowY = sc.nextInt();
			
			// 이동하고자 하는 좌표
			int wantX = sc.nextInt();
			int wantY = sc.nextInt();
			
			bfs(nowX, nowY, wantX, wantY);
		}
	}
}
