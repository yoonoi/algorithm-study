import java.util.Scanner;

public class Kh_1926 {
	public static int N, M, count, area;
	public static int[][] paper;
	public static boolean[][] visited;
	public static int[] dr = { -1, 1, 0, 0 };
	public static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		paper = new int[N][M];
		visited = new boolean[N][M];
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				paper[r][c] = sc.nextInt();
			}
		}

		int max = 0;
		count = 0 ; 
		area = 0;
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				area = 0;
				if (!visited[r][c] && paper[r][c] == 1) {
					count++;
					dfs(r, c);
					if(area > max) {
						max= area;
					}
				}
			}
		}
		
		System.out.println(count);
		System.out.println(max);

	}

	private static void dfs(int r, int c) {
		visited[r][c] = true;
		area++;

		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			if (nr >= 0 && nc >= 0 && nr < N && nc < M) {
				if(paper[nr][nc]==1 && !visited[nr][nc]) {
					dfs(nr, nc);
				}
			}
		}
		
		

	}
}
