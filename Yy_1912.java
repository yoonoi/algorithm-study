package dp;

import java.util.Scanner;

public class Yy_1912 {
	
	static int n, maxSum;
	static int[] arr, dp;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new int[n];
		for(int i=0; i<n; i++)
			arr[i] = sc.nextInt();
		
		dp = new int[n];
		
		System.out.println(makeDp());
	}
	
	static int makeDp() {
		dp[0] = arr[0];
		maxSum = arr[0];
		
		if(n == 1) 
			return arr[0];
		
		for(int i=1; i<n; i++) {
			dp[i] = Math.max(dp[i-1] + arr[i], arr[i]);
			maxSum = Math.max(maxSum, dp[i]);
		}
		
		return maxSum;
	}

}
