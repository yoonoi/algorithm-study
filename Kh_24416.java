import java.util.Scanner;

public class Kh_24416 {
	static int countRec = 0;
	static int countD = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int N = sc.nextInt();
		fib(N);
		fibonacci(N);
		sb.append(countRec).append(" ").append(countD);

		System.out.println(sb);
	}

	public static int fib(int n) {
		if (n == 1 || n == 2) {
			countRec++;
			return 1;
		}
		return fib(n - 1) + fib(n - 2);
	}

	public static int fibonacci(int n) {
		
		int[] dp = new int[n + 1];
		
		dp[1] = 1;
		dp[2] = 1;
		
		for (int i = 3; i <= n; i++) {
			countD++;
			dp[i] = dp[i-1]+dp[i-2];
		}
		
		return dp[n];
	}

}
