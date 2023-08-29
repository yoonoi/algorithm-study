import java.util.*;

public class Hw_1012 {
	static int M;
	static int N;
	static int num;
	static int[][] map;
	static boolean[][] visited;
	static int[] deltaRow = { 0, 0, -1, 1 };
	static int[] deltaCol = { -1, 1, 0, 0 };
	static int result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int testCase = sc.nextInt();
		for (int tc = 1; tc <= testCase; tc++) {
			M = sc.nextInt();
			N = sc.nextInt();
			num = sc.nextInt();
			map = new int[N][M];
			visited = new boolean[N][M];
			result = 0;

			for (int i = 0; i < num; i++) {
				int col = sc.nextInt();
				int row = sc.nextInt();
				map[row][col] = 1;
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (map[i][j] == 1 && !visited[i][j]) {
						dfs(i, j);
						result++;
					}
				}
			}
			System.out.println(result);
		}
	}

	public static void dfs(int row, int col) {
		visited[row][col] = true;

		for (int i = 0; i < 4; i++) {
			int newRow = row + deltaRow[i];
			int newCol = col + deltaCol[i];

			if (newRow < 0 || newRow >= N || newCol < 0 || newCol >= M) {
				continue;
			}
			if (map[newRow][newCol] == 0 || visited[newRow][newCol]) {
				continue;
			}
			dfs(newRow, newCol);
		}

	}
}
