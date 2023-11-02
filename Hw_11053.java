import java.util.*;

public class Hw_11053 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] arr = new int[N];
		int[] dp = new int[N];
		for(int i = 0; i < N; i++) {
			dp[i] = 1;
		}
		int result = 1;
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i = 1; i < N; i++) {
			
			for(int j = 0; j < i; j++) {
				if(arr[i] > arr[j] && dp[i] <= dp[j]) {
					dp[i] = dp[j] + 1;
				}
			}
			result = Math.max(result, dp[i]);
		}
		System.out.println(result);
	}
}
