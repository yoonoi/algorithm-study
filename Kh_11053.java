package silver;

import java.util.Arrays;
import java.util.Scanner;

public class Kh_11053 {
	static int[] seq, dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		seq = new int[N];
		for(int i = 0 ; i < N ; i++) {
			seq[i] = sc.nextInt();
		}
		
		
		dp = new int[N];
		dp[0] = 1;
		int result = 1;
		
		for(int i = 1 ; i < N ; i++) {
			dp[i] = 1;
			for(int j = 0 ; j < i ; j++) {
				if(seq[i]>seq[j] && dp[i] <= dp[j]) {
					dp[i] = dp[j]+1;
				}
				
			}
			result = Math.max(result, dp[i]);
		}
		
		System.out.println(result);
		
	}
	
	
}