package gold;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Kh_7576 {
	static class Spot {
		int row;
		int col;
		int days;

		public Spot(int r, int c, int d) {
			this.row = r;
			this.col = c;
			this.days = d;
		}
	}

	public static int M, N, count, shortest;
	public static int[][] box;
	public static boolean[][] visited;
	public static Queue<Spot> Q = new LinkedList<>();
	public static int[] dr = { -1, 1, 0, 0 };
	public static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		M = sc.nextInt();
		N = sc.nextInt();

		box = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				box[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (box[i][j] == 1 && !visited[i][j]) {

					Q.add(new Spot(i,j,0));
					visited[i][j] = true;
					
				}
			}
		}
		
		while (!Q.isEmpty()) {
			Spot tmp = Q.poll();

			int curRow = tmp.row;
			int curCol = tmp.col;
			int curDays = tmp.days;
			count = curDays;
			for (int i = 0; i < 4; i++) {
				int nr = curRow + dr[i];
				int nc = curCol + dc[i];

				if (nr >= 0 && nc >= 0 && nr < N && nc < M && !visited[nr][nc]) {
					if (box[nr][nc] == 0) {
						box[nr][nc] = 1;
						Q.add(new Spot(nr, nc, curDays + 1));
						visited[nr][nc] = true;
					}
				}
			}
		}
		
		
		if(isPossible()) {
			System.out.println(count);
		}else {
			System.out.println(-1);
		}
	}
	
	public static boolean isPossible() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (box[i][j] == 0) {
					return false;
				}
			}
		}
		return true;
		
	}

}
