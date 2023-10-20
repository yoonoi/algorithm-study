import java.util.*;

public class Hw_1937_ {
	static int N;
	static int[][] map;
	static int[][] dp;
	static int[] deltaRow = { 0, 0, -1, 1 };
	static int[] deltaCol = { -1, 1, 0, 0 };
	static int result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		dp = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		result = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				result = Math.max(result, dfs(i, j));
			}
		}
		System.out.println(result);
	}

	static int dfs(int row, int col) {
		if (dp[row][col] != 0) {
			return dp[row][col];
		}
		dp[row][col] = 1;

		for (int i = 0; i < 4; i++) {
			int newRow = row + deltaRow[i];
			int newCol = col + deltaCol[i];
			if (newRow < 0 || newRow >= N || newCol < 0 || newCol >= N) {
				continue;
			}
			if (map[row][col] < map[newRow][newCol]) {
				dp[row][col] = Math.max(dp[row][col], dfs(newRow, newCol) + 1);
				dfs(newRow, newCol);
			}

		}
		return dp[row][col];
	}
}
