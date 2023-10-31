import java.util.Scanner;

public class Mw_1904 {
    static long[] dp;

    static long DP(int num) {
        for(int idx = 3; idx < num + 1; idx++) {
            dp[idx] = (dp[idx - 1] + dp[idx - 2]) % 15746;
        }
        return dp[num];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        dp = new long[N+1];
        dp[1] = 1;
        if(N >= 2) dp[2] = 2;

        System.out.println(DP(N));
    }
}
