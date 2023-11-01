package dp;

import java.util.Scanner;

public class Yy_1463 {
	
	static int[] dp;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		dp = new int[n+1];
		
//		System.out.println(doDp(n));
		System.out.println(dpdp(n));
	}
	
	// 방법1
	static int doDp(int k) {
		
		if(k == 1)
			return 0;
		
		if(k == 2 || k == 3)
			return 1;
		
		dp[2] = 1;
		dp[3] = 1;
		
		for(int i=4; i<=k; i++) {
			dp[i] = dp[i-1] + 1;
			
			if(i % 3 == 0) 
				dp[i] = Math.min(dp[i], dp[i/3] + 1);
			
			// 6의 공배수일 때 어케될지 몰라서 else if가 아닌 그냥 if 사용
			if(i % 2 == 0) 
				dp[i] = Math.min(dp[i], dp[i/2] + 1);
		}
		
		return dp[k];
	}
	
	// 방법2
    static int dpdp(int k) {
        for(int i=2; i<=k; i++) {
        	dp[i] = dp[i-1] + 1;
        	
            if(i % 3 == 0) {
                dp[i] = Math.min(dp[i/3] + 1, dp[i]);
            }
            if(i % 2 == 0) {
                dp[i] = Math.min(dp[i/2] + 1, dp[i]);
            }

        }

        return dp[k];
    }

}
