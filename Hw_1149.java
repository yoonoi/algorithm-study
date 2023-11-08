import java.util.*;

public class Hw_1149 {
	final static int Red = 0;
	final static int Green = 1;
	final static int Blue = 2;

	static int[][] rgb;
	static int[][] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		rgb = new int[N][3];
		dp = new int[N][3];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 3; j++) {
				rgb[i][j] = sc.nextInt();
			}
		}

		dp[0][Red] = rgb[0][Red];
		dp[0][Green] = rgb[0][Green];
		dp[0][Blue] = rgb[0][Blue];
		painting(N-1, Red);
		painting(N-1, Blue);
		painting(N-1, Green);
		int result = Math.min(dp[N - 1][Red], Math.min(dp[N - 1][Green], dp[N - 1][Blue]));
		System.out.println(result);
	}

	public static int painting(int N, int color) {

		if (dp[N][color] == 0) {
			if (color == Red) {
				dp[N][color] = Math.min(painting(N - 1, Green), painting(N - 1, Blue)) + rgb[N][color];
			} else if (color == Green) {
				dp[N][color] = Math.min(painting(N - 1, Red), painting(N - 1, Blue)) + rgb[N][color];
			} else {
				dp[N][color] = Math.min(painting(N - 1, Red), painting(N - 1, Green)) + rgb[N][color];
			}
		}

		return dp[N][color];

	}
}
