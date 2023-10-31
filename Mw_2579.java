import java.util.Scanner;

public class Mw_2579 {
    static int[] stair;
    static int[] dp;

    static int DP (int n) {
        if(n <= 3) return dp[n];
        for(int idx = 4; idx < n+1; idx++) {
            dp[idx] = Math.max(stair[idx] + dp[idx-2], stair[idx] + stair[idx-1] + dp[idx-3]);
        }
        return dp[n];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        stair = new int[N+1];
        for(int idx = 1; idx <= N; idx++) {
            stair[idx] = sc.nextInt();
        }

        dp = new int[N+1];

        dp[1] = stair[1];

        if(N == 2) {
            dp[2] = stair[1] + stair[2];
        }

        if(N >= 3) {
            dp[2] = stair[1] + stair[2];
            dp[3] = Math.max(stair[1] + stair[3], stair[2] + stair[3]);
        }
        System.out.println(DP(N));
    }
}