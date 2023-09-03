import java.util.*;

public class Hw_2206_ {
	static class Pos {
		int r, c, t;
		boolean destroy;

		public Pos(int r, int c, int t, boolean destroy) {
			this.r = r;
			this.c = c;
			this.t = t;
			this.destroy = destroy;
		}
	}

	static int[] deltaRow = { 0, 0, -1, 1 };
	static int[] deltaCol = { -1, 1, 0, 0 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] map = new int[N][M];
		boolean[][][] visited = new boolean[2][N][M];

		sc.nextLine(); // 개행 버림
		for (int i = 0; i < N; i++) {
			String input = sc.next();
			for (int j = 0; j < M; j++) {
				map[i][j] = input.charAt(j) - '0';
			}
		}
		
		Queue<Pos> queue = new LinkedList<>();
		queue.add(new Pos(0, 0, 1, false));

		while (!queue.isEmpty()) {
			Pos current = queue.poll();
			if (current.r == N - 1 && current.c == M - 1) {
				System.out.println(current.t);
				return;
			}
			for (int i = 0; i < 4; i++) {
				int newRow = current.r + deltaRow[i];
				int newCol = current.c + deltaCol[i];
				int newTime = current.t + 1;
				if (newRow < 0 || newRow >= N || newCol < 0 || newCol >= M) {
					continue;
				}

				if (map[newRow][newCol] == 0) {
					if (!current.destroy && !visited[0][newRow][newCol]) {
						queue.add(new Pos(newRow, newCol, newTime, false));
						visited[0][newRow][newCol] = true;
					} else if (current.destroy && !visited[1][newRow][newCol]) {
						queue.add(new Pos(newRow, newCol, newTime, true));
						visited[1][newRow][newCol] = true;
					}
				} else if (map[newRow][newCol] == 1 && !visited[1][newRow][newCol]) {
					if (!current.destroy) {
						queue.add(new Pos(newRow, newCol, newTime, true));
						visited[1][newRow][newCol] = true;
					}
				}
			}
		}
		System.out.println(-1);
	}
}