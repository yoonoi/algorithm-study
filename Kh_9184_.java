package silver;

import java.util.Scanner;

public class Kh_9184_ {
	static int[][][] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		dp = new int[21][21][21];

		while (true) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();

			if (a == -1 && b == -1 && c == -1)
				break;

			System.out.printf("w(%d, %d, %d) = %d\n", a, b, c, w(a, b, c));
		}
	}

	public static int w(int a, int b, int c) {
		if(inRange(a,b,c)&& dp[a][b][c] != 0) {
			return dp[a][b][c];
		}
		if (a <= 0 || b <= 0 || c <= 0) {
			return 1;
		}
		if (a > 20 || b > 20 || c > 20) {
			return dp[20][20][20] = w(20, 20, 20);
		}

		if (a < b && b < c) {
			return dp[a][b][c] = w(a, b, c - 1) + w(a, b - 1, c - 1) - w(a, b - 1, c);
		}

		return dp[a][b][c] = w(a - 1, b, c) + w(a - 1, b - 1, c) + w(a - 1, b, c - 1) - w(a - 1, b - 1, c - 1);

	}

	private static boolean inRange(int a2, int b2, int c2) {
		
		return a2>=0 && a2<=20 && b2>=0 && b2<=20 && c2>=0 && c2<=20;
	}

}
