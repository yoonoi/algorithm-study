import java.util.*;

public class Hw_14503 {
	static int N, M;
	static int[][] map;
	static boolean[][] visited;
	static int result;
	static int direction;
	static int[][] deltaRow = { { 0, 1, 0, -1 }, { -1, 0, 1, 0 }, { 0, -1, 0, 1 }, { 1, 0, -1, 0 } };
	static int[][] deltaCol = { { -1, 0, 1, 0 }, { 0, -1, 0, 1 }, { 1, 0, -1, 0 }, { 0, 1, 0, -1 } };
	static int nowRow;
	static int nowCol;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];

		nowRow = sc.nextInt();
		nowCol = sc.nextInt();
		direction = sc.nextInt();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		dfs();

	}

	public static void dfs() {
		if (map[nowRow][nowCol] == 0) {
			map[nowRow][nowCol] = 2;
			result++;
		}
		for (int i = 0; i < 4; i++) {
			int newRow = nowRow + deltaRow[direction][i];
			int newCol = nowCol + deltaCol[direction][i];
//			if (newRow < 0 || newRow >= N || newCol < 0 || newCol >= M) {
//				continue;
//			}
			int searchDirection = (direction - i - 1 + 4) % 4;
			if (map[newRow][newCol] == 0) {
				direction = searchDirection;
				goToForward();
				dfs();
				return;
			}
		}
		boolean flag = goToBack();
		if (flag) {
			dfs();
			return;
		} else {
			System.out.println(result);
			return;
		}
	}

	public static void goToForward() {
		if (direction == 0) {
			nowRow = nowRow - 1;
//			if (newRow >= 0) {
//				nowRow = newRow;
//			}
		} else if (direction == 1) {
			nowCol = nowCol + 1;
//			if (newCol < M) {
//				nowCol = newCol;
//			}
		} else if (direction == 2) {
			nowRow = nowRow + 1;
//			if (newRow < N) {
//				nowRow = newRow;
//			}
		} else {
			nowCol = nowCol - 1;
//			if (newCol >= 0) {
//				nowCol = newCol;
//			}
		}
	}

	public static boolean goToBack() {
		boolean canGo = false;
		if (direction == 0) {
			int newRow = nowRow + 1;
			if (map[newRow][nowCol] != 1) {
				nowRow = newRow;
				canGo = true;
			}
		} else if (direction == 1) {
			int newCol = nowCol - 1;
			if (map[nowRow][newCol] != 1) {
				nowCol = newCol;
				canGo = true;
			}
		} else if (direction == 2) {
			int newRow = nowRow - 1;
			if (map[newRow][nowCol] != 1) {
				nowRow = newRow;
				canGo = true;
			}
		} else {
			int newCol = nowCol + 1;
			if (map[nowRow][newCol] != 1) {
				nowCol = newCol;
				canGo = true;
			}
		}
		return canGo;
	}
}