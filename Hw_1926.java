import java.util.*;

public class Hw_1926 {
	static int row;
	static int col;
	static boolean[][] visited;
	static int[][] map;
	static int maxArea = 0;
	static int area = 0;
	static int count = 0;
	static int[] deltaRow = { 0, 0, 1, -1 };
	static int[] deltaCol = { 1, -1, 0, 0 };

	public static void main(String agrs[]) {
		Scanner sc = new Scanner(System.in);
		row = sc.nextInt();
		col = sc.nextInt();
		map = new int[row][col];
		visited = new boolean[row][col];

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (!visited[i][j] && map[i][j] == 1) {
					dfs(i, j);
					count++;
				}
				if (maxArea < area) {
					maxArea = area;
				}
				area = 0;
			}
		}

		System.out.println(count);
		System.out.println(maxArea);
	}

	public static void dfs(int r, int c) {
		visited[r][c] = true;
		area++;
		for (int i = 0; i < 4; i++) {
			int newRow = r + deltaRow[i];
			int newCol = c + deltaCol[i];
			if (newRow < 0 || newRow >= row || newCol < 0 || newCol >= col) {
				continue;
			}
			if (!visited[newRow][newCol] && map[newRow][newCol] == 1) {
				dfs(newRow, newCol);
			}
		}

	}
}