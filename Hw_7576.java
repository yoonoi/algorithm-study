import java.util.*;

public class Hw_7576 {
	static int M;
	static int N;
	static int[][] box;
	static boolean[][] checked;
	static Queue<pos> queue = new LinkedList<>();
	static int[] deltaRow = { 0, 0, -1, 1 };
	static int[] deltaCol = { -1, 1, 0, 0 };
	static int lastDay;

	static class pos {
		int r, c, d;

		public pos(int r, int c, int d) {
			this.r = r;
			this.c = c;
			this.d = d;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		box = new int[N][M];
		checked = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				box[i][j] = sc.nextInt();
			}
		}
		bfs();
		
		for(int i = 0; i < N;i ++) {
			for(int j = 0; j < M; j++) {
				if(box[i][j] == 0) {
					System.out.println(-1);
					return;
				}
			}
		}
		System.out.println(lastDay - 1);
	}

	public static void bfs() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (box[i][j] == 1) {
					queue.add(new pos(i, j, 0));
					checked[i][j] = true;
				}
			}
		}

		while (!queue.isEmpty()) {
			pos current = queue.poll();
			int nowRow = current.r;
			int nowCol = current.c;
			int nowDay = current.d;

			for (int i = 0; i < 4; i++) {
				int newRow = nowRow + deltaRow[i];
				int newCol = nowCol + deltaCol[i];
				lastDay = nowDay + 1;
				if (newRow < 0 || newRow >= N || newCol < 0 || newCol >= M) {
					continue;
				}
				if (!checked[newRow][newCol] && box[newRow][newCol] == 0) {
					box[newRow][newCol] = 1;
					queue.add(new pos(newRow, newCol, lastDay));
					checked[newRow][newCol] = true;
				}
			}
		}
	}

}