package silver;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Kh_1012 {
	static class Location {
		int r;
		int c;

		public Location(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 0; tc < T; tc++) {
			int M = sc.nextInt();
			int N = sc.nextInt();
			int K = sc.nextInt();

			boolean[][] map = new boolean[N][M];

			for (int i = 0; i < K; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				map[y][x] = true;
			}

			Queue<Location> Q = new LinkedList<>();

			int[] dr = { -1, 1, 0, 0 };
			int[] dc = { 0, 0, -1, 1 };
			int count = 0;

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					if (map[r][c]) {
						Q.add(new Location(r, c));
						map[r][c] = false;
						while (!Q.isEmpty()) {
							Location now = Q.poll();

							for (int i = 0; i < 4; i++) {
								int nr = now.r + dr[i];
								int nc = now.c + dc[i];
								if (nr < 0 || nc < 0 || nr >= N || nc >= M) {
									continue;
								}
								if (map[nr][nc]) {
									Q.add(new Location(nr, nc));
									map[nr][nc] = false;
								}
							}
						}

						count++;
					}
				}
			}

			System.out.println(count);

		}

	}
}