package silver;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Kh_7562 {
	static class Location {
		int r;
		int c;
		int t;

		public Location(int r, int c, int t) {
			this.r = r;
			this.c = c;
			this.t = t;

		}
	}

	static int[] dr = { -1, -2, -2, -1, 1, 2, 2, 1 };
	static int[] dc = { -2, -1, 1, 2, 2, 1, -1, -2 };
	static int L, departureR, departureC, destinationR, destinationC;
	static Queue<Location> Q;
	static boolean[][] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 0; tc < T; tc++) {
			L = sc.nextInt();

			departureR = sc.nextInt();
			departureC = sc.nextInt();
			destinationR = sc.nextInt();
			destinationC = sc.nextInt();

			Q = new LinkedList<>();
			visited = new boolean[L][L];

			if (departureR == destinationR && departureC == destinationC) {
				System.out.println(0);
			} else {
				bfs();
			}

		}

	}

	public static void bfs() {
		Q.add(new Location(departureR, departureC, 0));
		visited[departureR][departureC] = true;

		while (!Q.isEmpty()) {
			Location tmp = Q.poll();

			for (int i = 0; i < 8; i++) {
				int nr = tmp.r + dr[i];
				int nc = tmp.c + dc[i];
				int nt = tmp.t + 1;

				if (nr == destinationR && nc == destinationC) {
					System.out.println(nt);
					return;
				}

				if (nr < 0 || nc < 0 || nr >= L || nc >= L) {
					continue;
				}

				if (visited[nr][nc]) {
					continue;
				}
				Q.add(new Location(nr, nc, nt));
				visited[nr][nc] = true;

			}
		}
	}
}
