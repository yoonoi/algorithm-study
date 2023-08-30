package gold;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Kh_7569 {
	static class Tomato {
		int r;
		int c;
		int h;
		int d;

		public Tomato(int r, int c, int h, int d) {
			this.r = r;
			this.c = c;
			this.h = h;
			this.d = d;
		}
	}

	static int M, N, H, count;
	static int[][][] box;
	static int[] dr = { -1, 1, 0, 0, 0, 0 };
	static int[] dc = { 0, 0, -1, 1, 0, 0 };
	static int[] dh = { 0, 0, 0, 0, -1, 1 };
	static Queue<Tomato> Q;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		H = sc.nextInt();

		box = new int[H][N][M];
		count = 0;

		Q = new LinkedList<>();

		for (int h = 0; h < H; h++) {
			for (int n = 0; n < N; n++) {
				for (int m = 0; m < M; m++) {
					box[h][n][m] = sc.nextInt();
				}
			}
		} // 집어넣어주기
		
		for (int h = 0; h < H; h++) {
			for (int n = 0; n < N; n++) {
				for (int m = 0; m < M; m++) {
					if (box[h][n][m] == 1) {
						Q.add(new Tomato(n, m, h, 0));
					}
				}
			}
		}
		bfs();
		
		if(isPossible()) {
			System.out.println(count);
		}else {
			System.out.println(-1);
		}

	}

	public static void bfs() {
		while (!Q.isEmpty()) {
			Tomato tmp = Q.poll();
			count = tmp.d;
			for (int d = 0; d < 6; d++) {
				int nr = tmp.r + dr[d];
				int nc = tmp.c + dc[d];
				int nh = tmp.h + dh[d];
				int nd = tmp.d + 1;
				if(nr<0 || nc < 0 || nh < 0 || nr >= N || nc >= M || nh >= H ) {
					
					continue;
				}
				
				
				if(box[nh][nr][nc] == 0) {
					box[nh][nr][nc] = 1;
					Q.add(new Tomato(nr, nc, nh, nd));
				}
					
			}
		}

	}

	public static boolean isPossible() {
		for (int h = 0; h < H; h++) {
			for (int n = 0; n < N; n++) {
				for (int m = 0; m < M; m++) {
					if (box[h][n][m] == 0)
						return false;
				}
			}
		}
		return true;
	}

}
