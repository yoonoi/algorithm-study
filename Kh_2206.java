package gold;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Kh_2206 {
	static class Location {
		int r;
		int c;
		int d;
		int breakCount;

		public Location(int r, int c, int d, int b) {
			this.r = r;
			this.c = c;
			this.d = d;
			this.breakCount = b;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		int N = sc.nextInt();
		int M = sc.nextInt();
		if (N == 1 && M == 1) {
			System.out.println(1);
			return;
		}

		int[][] map = new int[N + 1][M + 1];
		boolean[][] visited = new boolean[N + 1][M + 1];
		boolean[][] visitedByBreak = new boolean[N + 1][M + 1];
		Queue<Location> Q = new LinkedList<>();

		for (int i = 1; i <= N; i++) {
			String str = sc.next();
			for (int j = 0; j < M; j++) {
				map[i][j + 1] = str.charAt(j) - '0';

			}
		}

		Q.add(new Location(1, 1, 1, 0));
		visited[1][1] = true;

		while (!Q.isEmpty()) {
			Location tmp = Q.poll();

			for (int d = 0; d < 4; d++) {
				int nr = tmp.r + dr[d];
				int nc = tmp.c + dc[d];
				int nd = tmp.d + 1;

				if (nr == N && nc == M) {
					System.out.println(nd);
					return;
				}

				if (nr < 1 || nc < 1 || nr > N || nc > M || visited[nr][nc]) {
					continue;
				}

				if (map[nr][nc] == 0) {

					if (tmp.breakCount == 0) {
						Q.add(new Location(nr, nc, nd, tmp.breakCount));

						visited[nr][nc] = true;
					} else {
						if (!visitedByBreak[nr][nc]) {
							Q.add(new Location(nr, nc, nd, tmp.breakCount));
							visitedByBreak[nr][nc] = true;
						}
					}

				}

				if (map[nr][nc] == 1 && tmp.breakCount == 0) {
					Q.add(new Location(nr, nc, nd, tmp.breakCount + 1));
					visited[nr][nc] = true;

				}

			}

		}

		System.out.println(-1);

	}

}
