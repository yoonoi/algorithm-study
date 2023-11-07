import java.util.*;

public class Hw_1912 {
	static int[] dp;
	static int[] arr;
	static int max;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		dp = new int[n];
		arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}

		dp[0] = arr[0];
		max = arr[0];
		for (int i = 1; i < n; i++) {
			dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
			max = Math.max(dp[i], max);
		}
		System.out.println(max);
	}

}
