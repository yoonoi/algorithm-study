package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Yy_11053_ {
	
	static int n;
	static int[] arr, dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) 
			arr[i] = Integer.parseInt(st.nextToken());
		
		dp = new int[n];
		Arrays.fill(dp, 1);
		
		System.out.println(dpdp());
	}
	
	static int dpdp() {
		int maxLength = 1;
		
		if(n == 1)
			return maxLength;
		
		for(int i=1; i<n; i++) {
			for(int j=0; j<i; j++) {
				if(arr[j] < arr[i]) {
					dp[i] = Math.max(dp[j] + 1, dp[i]);
				}
			}
		}
		
		for(int i=0; i<n; i++) {
			if(maxLength < dp[i])
				maxLength = dp[i];
		}
		
//		System.out.println(Arrays.toString(dp));
		
		return maxLength;
	}

}
