package gold;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Kh_14503 {
	static class Location {
		int r;
		int c;

		public Location(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int[][] room;
	static boolean[][] visited;
	static int N, M, count, D;
	static Queue<Location> Q;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		int r = sc.nextInt();
		int c = sc.nextInt();
		D = sc.nextInt();

		room = new int[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				room[i][j] = sc.nextInt();
			}
		}

		Q = new LinkedList<>();
		count = 0;

		Q.add(new Location(r, c));
		if (room[r][c] == 0) {
			visited[r][c] = true;
			count++;
		}

		while (!Q.isEmpty()) {
			Location tmp = Q.poll();
			int tr = tmp.r;
			int tc = tmp.c;

			if (isCleanable(tr, tc)) {
				toGo(tr, tc);
			} else {
				switch (D) {
				case 0:
					if (room[tr + 1][tc] == 1) {
						System.out.println(count);
						return;
					}
					Q.add(new Location(tr + 1, tc));
					break;
				case 1:
					if (room[tr][tc - 1] == 1) {
						System.out.println(count);
						return;
					}
					Q.add(new Location(tr, tc - 1));
					break;
				case 2:
					if (room[tr - 1][tc] == 1) {
						System.out.println(count);
						return;
					}
					Q.add(new Location(tr - 1, tc));
					break;
				case 3:
					if (room[tr][tc + 1] == 1) {
						System.out.println(count);
						return;
					}
					Q.add(new Location(tr, tc + 1));
					break;
				default:
					break;
				}
			}

		}

	}

	/*
	 * 0:북 1:동 2:남 3:서
	 */
	static boolean isCleanable(int r, int c) {
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (room[nr][nc] == 0&& !visited[nr][nc]) {
				return true;
			}
		}

		return false;
	}

	static void toGo(int r, int c) {
		while (true) {
			D = (D - 1 + 4) % 4;

			switch (D) {
			case 0:
				if (room[r - 1][c] == 0 && !visited[r - 1][c]) {
					Q.add(new Location(r - 1, c));
					visited[r - 1][c] = true;
					count++;
					return;
				}
				break;
			case 1:
				if (room[r][c + 1] == 0 && !visited[r][c + 1]) {
					Q.add(new Location(r, c + 1));
					visited[r][c + 1] = true;
					count++;
					return;
				}
				break;
			case 2:
				if (room[r + 1][c] == 0 && !visited[r + 1][c]) {
					Q.add(new Location(r + 1, c));
					visited[r + 1][c] = true;
					count++;
					return;
				}
				break;
			case 3:
				if (room[r][c - 1] == 0 && !visited[r][c - 1]) {
					Q.add(new Location(r, c - 1));
					visited[r][c - 1] = true;
					count++;
					return;
				}
				break;
			default:
				break;
			}
		}

	}

}
