import java.util.Scanner;

public class Jh_2839 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[5001];

        dp[3] = dp[5] = 1;
        dp[4] = dp[7] = -1;
        dp[6] = 2;

        int min = Integer.MAX_VALUE;

        for (int i = 8; i <= n; i++) {
            // 가능
            if (dp[i - 3] != -1)
                dp[i] = Math.min(dp[i - 3] + 1, min);
            if (dp[i - 5] != -1)
                dp[i] = Math.min(dp[i - 5] + 1, min);
            else if(dp[i-3]==-1&&dp[i-5]==-1){
                dp[i] = -1;
            }
        }
        System.out.println(dp[n] == 0 ? -1 : dp[n]);
    }
}
