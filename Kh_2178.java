import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Kh_2178 {

	static class Node {
		int r, c, distance;

		public Node(int r, int c, int distance) {
			this.r = r;
			this.c = c;
			this.distance = distance;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] map = new int[N][M];
		boolean[][] visited = new boolean[N][M];

		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		for (int i = 0; i < N; i++) {
			String line = sc.next();
			for (int j = 0; j < M; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}
		Queue<Node> Q = new LinkedList<>();

		Q.add(new Node(0, 0, 1));
		visited[0][0] = true;

		while (!Q.isEmpty()) {
			Node tmp = Q.poll();

			for (int i = 0; i < 4; i++) {
				int nr = tmp.r + dr[i];
				int nc = tmp.c + dc[i];
				int nextDist = tmp.distance + 1;

				if (nr >= 0 && nc >= 0 && nr < N && nc < M && map[nr][nc]==1 && !visited[nr][nc]) {
					if (nr == N - 1 && nc == M - 1) {
						System.out.println(nextDist);
						return;
					}

					Q.add(new Node(nr, nc, nextDist));
					visited[nr][nc] = true;

				}
			}
		}
	}

}
