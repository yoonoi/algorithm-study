import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Hw_2178 {

	static class pos {
		int r, c, d;

		public pos(int r, int c, int d) {
			this.r = r;
			this.c = c;
			this.d = d;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int row = Integer.parseInt(st.nextToken());
		int col = Integer.parseInt(st.nextToken());
		int[][] map = new int[row][col];
		boolean[][] visited = new boolean[row][col];
		int[] deltaRow = { 0, 0, -1, 1 };
		int[] deltaCol = { 1, -1, 0, 0 };
		Queue<pos> queue = new LinkedList<>();
		for (int i = 0; i < row; i++) {
			String str = br.readLine();
			for (int j = 0; j < str.length(); j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}

		queue.add(new pos(0, 0, 1));
		visited[0][0] = true;
		while (!queue.isEmpty()) {
			pos current = queue.poll();
			int nowRow = current.r;
			int nowCol = current.c;
			int nowDistance = current.d;
			for (int i = 0; i < 4; i++) {
				int newRow = nowRow + deltaRow[i];
				int newCol = nowCol + deltaCol[i];
				int newDistance = nowDistance + 1;
				if (newRow < 0 || newRow >= row || newCol < 0 || newCol >= col || visited[newRow][newCol] ) {
					continue;
				}
				if (newRow == row - 1 && newCol == col - 1) {
					System.out.println(newDistance);
					return;
				}
				if (!visited[newRow][newCol] && map[newRow][newCol] == 1) {
					queue.add(new pos(newRow, newCol, newDistance));
					visited[newRow][newCol] = true;
				}
			}
		}

	}

}