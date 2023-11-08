import java.util.Scanner;

public class Mw_1149 {
    static int[][] arr;
    static int[][] dp;

    static void DP(int n) {
        dp[0][0] = arr[0][0];
        dp[0][1] = arr[0][1];
        dp[0][2] = arr[0][2];

        for(int idx = 1; idx < n; idx++) {
            dp[idx][0] = Math.min(dp[idx-1][1], dp[idx-1][2]) + arr[idx][0];
            dp[idx][1] = Math.min(dp[idx-1][0], dp[idx-1][2]) + arr[idx][1];
            dp[idx][2] = Math.min(dp[idx-1][0], dp[idx-1][1]) + arr[idx][2];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        arr = new int[N][3];
        dp = new int[N][3];
        for(int row = 0; row < N; row++) {
            for(int col = 0; col < 3; col++) {
                arr[row][col] = sc.nextInt();
            }
        }
        DP(N);
        int min = Math.min(dp[N-1][0],Math.min(dp[N-1][1], dp[N-1][2]));
        System.out.println(min);
    }
}
