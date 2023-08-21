import java.util.Scanner;

public class Kh_9663 {
	public static int[][]  check;
//	public static boolean[][] check, initialized;
	public static int N, count;
	public static int[] dr = { 1, 1, 1 };
	public static int[] dc = { -1, 0, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		check = new int[N][N];

		count = 0;

		queen(0);

		System.out.println(count);
	}

	
	public static void queen(int r) {
		if (r == N) {
			count++;
			return;
		}

		if (!isPossible(r)) {
			return;
		}

		for (int c = 0; c < N; c++) {
			if (check[r][c] == 0) {
				convertOccupied(r, c);
				queen(r + 1);
				initialize(r, c);
			}
		}

	}

	// 해당 줄에 놓을 수 있는가
	public static boolean isPossible(int r) {
		for (int i = 0; i < N; i++) {
			if (check[r][i] == 0) {
				return true;
			}
		}
		return false;
	}

	// 불가능한 곳 표시
	public static void convertOccupied(int r, int c) {
		for (int i = 0; i < N - r; i++) {
			for (int d = 0; d < 3; d++) {
				int nr = r + dr[d] * i;
				int nc = c + dc[d] * i;

				if (nr >= 0 && nc >= 0 && nr < N && nc < N) {
					check[nr][nc]++; // 1이상=occupied
					// 0만 놓을 수 있다.
				}
			}
		}
	}
	
	// 불가능한 곳 표시한 거 초기화
	public static void initialize(int r, int c) {
		for (int i = 0; i < N - r; i++) {
			for (int d = 0; d < 3; d++) {
				int nr = r + dr[d] * i;
				int nc = c + dc[d] * i;

				if (nr >= 0 && nc >= 0 && nr < N && nc < N) {
					check[nr][nc]--; // 똑같은 곳 초기화
				}
			}
		}
	}
}
