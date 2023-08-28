import java.util.*;

public class Hw_2667 {
	static int N;
	static int[][] map;
	static int result;
	static int idx;
	static int num;
	static int[] arr;
	static boolean[][] visited;
	static int[] deltaRow = { 0, 0, -1, 1 };
	static int[] deltaCol = { -1, 1, 0, 0 };
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		visited = new boolean[N][N];
		arr = new int[N * N];
		sc.nextLine(); // 개행 버림
		for (int i = 0; i < N; i++) {
			String str = sc.next();
			for (int j = 0; j < N; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j] && map[i][j] == 1) {
					num = 0;
					dfs(i, j);
					result++;
					arr[idx++] = num;
				}
			}
		}
		
		sb.append(result).append('\n');
		Arrays.sort(arr);
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != 0) {
				sb.append(arr[i]).append('\n');
			}
		}
		System.out.println(sb);
	}

	public static void dfs(int row, int col) {
		visited[row][col] = true;
		num++;
		for (int i = 0; i < 4; i++) {
			int newRow = row + deltaRow[i];
			int newCol = col + deltaCol[i];
			if (newRow < 0 || newRow >= N || newCol < 0 || newCol >= N) {
				continue;
			}
			if (map[newRow][newCol] == 0 || visited[newRow][newCol]) {
				continue;
			}
			visited[newRow][newCol] = true;
			dfs(newRow, newCol);
		}
	}
}
