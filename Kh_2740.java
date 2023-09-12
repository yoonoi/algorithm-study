import java.util.Scanner;

public class Kh_2740 {
	static int[][] A, B;
	static int N, M, K;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();

		A = new int[N][M];

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				A[r][c] = sc.nextInt();
			}
		}

		M = sc.nextInt();
		K = sc.nextInt();

		B = new int[M][K];
		for (int r = 0; r < M; r++) {
			for (int c = 0; c < K; c++) {
				B[r][c] = sc.nextInt();
			}
		}
		
		for(int i = 0 ; i < N ; i++) {
			for(int j = 0 ; j < K ; j++) {
				getMatrix(i,j);
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}

	private static void getMatrix(int i, int j) {
		int result = 0;
		for(int m = 0 ; m < M ; m++) {
			result += A[i][m]*B[m][j];
		}
		sb.append(result).append(" ");
	}

}
