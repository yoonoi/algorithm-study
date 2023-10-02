package bonus;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class Yy_17135 {

	static int n, m, d, ans;
	static int[][] board;
	static int[] selected = new int[3];
	static Set<Point> enemys;
	static boolean[][] killed;
	
	// 1. 거리가 d 이하인 적중에 제일 가까운 적
	// 2. 거리가 같은 적이 여럿일 경우는 가장 왼쪽에 있는 적을 죽인다.
	// 위의 조건을 위해 클래스 만들깅
	static class Enemy implements Comparable<Enemy> {
		int row;
		int col;
		int distance;
		
		public Enemy(int row, int col, int distance) {
			this.row = row;
			this.col = col;
			this.distance = distance;
		}

		@Override
		public int compareTo(Enemy o) {
			// 거리가 다르다면 거리순으로 오름차순(거리 가까운 애부터 정렬)
			if(o.distance != this.distance)
				return this.distance - o.distance;
			
			// 거리가 같다면 왼쪽에 있는애(col이 작은애) 순으로 오름차순 정렬
			else
				return this.col - o.col;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		ans = 0;
		
		board = new int[n][m]; 
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		setIndex(0, 0);
		System.out.println(ans);
	}

	// m열 중에 3개의 인덱스 조합 고르기
	static void setIndex(int idx, int sIdx) {
		// 3개 다 골랐으면
		if(sIdx == 3) {
			killed = new boolean[n][m];
			enemys = new HashSet<>();
			
			for(int i=0; i<n; i++) {
				
				for(int j=0; j<3; j++) 
					killTheEnemy(selected[j], i);
				
				for(Point kill : enemys) 
					killed[kill.x][kill.y] = true;
			}
			
			if(ans < enemys.size())
				ans = enemys.size();
			return;
		}
		
		// m개 다 탐색했으면 종료
		if(idx == m) return;
		
		selected[sIdx] = idx;
		setIndex(idx+1, sIdx+1); // idx를 sIdx인덱스에 넣었을 때
		setIndex(idx+1, sIdx); // idx를 sIdx인덱스에 안넣었을 때
	}
	
	static void killTheEnemy(int col, int move) {
		PriorityQueue<Enemy> pq = new PriorityQueue<>();
		
		for(int i=n-1-move; i>=n-1-move-d; i--) {
			if(i < 0) continue;
			
			for(int j=0; j<m; j++) {
				if(board[i][j] == 1 && !killed[i][j]) {
					int distance = getDistance(n-move, col, i, j);
					
					if(distance <= d) 
						pq.offer(new Enemy(i, j, distance));
				}
			}
		}
		
		Enemy kill = pq.poll();
		if(kill != null) {
			Point killed = new Point(kill.row, kill.col);
			enemys.add(killed);
		}
	}
	
	// 거리 구하는 메서드
	static int getDistance(int x1, int y1, int x2, int y2) {
		return Math.abs(x1 - x2) + Math.abs(y1 - y2);
	}
	
}
