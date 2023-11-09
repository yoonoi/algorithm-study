import java.util.*;

public class Hw_1932 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] num = new int[N][];

		for (int i = 0; i < N; i++) {
			num[i] = new int[i + 1];

			for (int j = 0; j <= i; j++) {
				num[i][j] = sc.nextInt();
			}
		}

		for (int i = N - 1; i >= 0; i--) {
			for (int j = 0; j < i; j++) {
				num[i - 1][j] += Math.max(num[i][j], num[i][j + 1]);
			}
		}
		
		System.out.println(num[0][0]);
	}

}
