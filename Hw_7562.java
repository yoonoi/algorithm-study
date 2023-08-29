import java.util.*;

public class Hw_7562 {
	static int mapSize;
	static boolean[][] visited;
	static int[] deltaRow = { 1, 1, 2, 2, -1, -1, -2, -2 };
	static int[] deltaCol = { 2, -2, 1, -1, -2, 2, -1, 1 };
	static int result;
	static int goalRow;
	static int goalCol;
	static StringBuilder sb = new StringBuilder();

	static class Pos {
		int r, c, t;

		public Pos(int r, int c, int t) {
			this.r = r;
			this.c = c;
			this.t = t;
		}
	}

	static Queue<Pos> queue;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int testCase = sc.nextInt();
		for (int tc = 1; tc <= testCase; tc++) {
			result = 0;
			mapSize = sc.nextInt();
			visited = new boolean[mapSize][mapSize];
			for (int i = 0; i < mapSize; i++) {
				for (int j = 0; j < mapSize; j++) {
					visited[i][j] = false;
				}
			}
			queue = new LinkedList<>();
			int startRow = sc.nextInt();
			int startCol = sc.nextInt();
			goalRow = sc.nextInt();
			goalCol = sc.nextInt();
			bfs(startRow, startCol);
		}
		System.out.println(sb);
	}

	public static void bfs(int row, int col) {
		queue.add(new Pos(row, col, 0));
		visited[row][col] = true;
		if (row == goalRow && col == goalCol) {
			sb.append(0).append('\n');
			return;
		}
		while (!queue.isEmpty()) {
			Pos current = queue.poll();
			int currentR = current.r;
			int currentC = current.c;
			int currentT = current.t;
			for (int i = 0; i < 8; i++) {
				int newRow = currentR + deltaRow[i];
				int newCol = currentC + deltaCol[i];
				int newTime = currentT + 1;

				if (newRow == goalRow && newCol == goalCol) {
					sb.append(newTime).append('\n');
					return;
				}
				if (newRow < 0 || newRow >= mapSize || newCol < 0 || newCol >= mapSize) {
					continue;
				}
				if (visited[newRow][newCol]) {
					continue;
				}
				queue.add(new Pos(newRow, newCol, newTime));
				visited[newRow][newCol] = true;
			}
		}
	}
}
