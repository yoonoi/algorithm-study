package BOJ;

import java.util.Scanner;

public class Mw_1463 {
    static int N;
    static int[] dp;

    static int one(int X) {
        if(X <= 3) return dp[X];
        for(int idx = 4; idx <= N; idx++) {
            if(idx % 2 == 0 && idx % 3 != 0) dp[idx] = Math.min(dp[idx/2], dp[idx-1]) + 1; // 수가 2로만 나눌 수 있는 경우.
            else if(idx % 2 != 0 && idx % 3 == 0) dp[idx] = Math.min(dp[idx/3], dp[idx-1]) + 1; // 수가 3으로만 나눌 수 있는 경우.
            else if(idx % 2 == 0 && idx % 3 == 0) dp[idx] = Math.min(Math.min(dp[idx/2], dp[idx/3]), dp[idx-1]) + 1; // 수가 2와 3으로 나눌 수 있는 경우.
            else dp[idx] = dp[idx-1] + 1; // 수가 2와 3으로 나눠지지 않는 경우.
        }
        return dp[X];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        dp = new int[N+1];

        dp[1] = 0;
        if(N == 2) dp[2] = 1;
        if(N >= 3) {
            dp[2] = 1;
            dp[3] = 1;
        }
        System.out.println(one(N));
    }
}
