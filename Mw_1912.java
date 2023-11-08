import java.util.Arrays;
import java.util.Scanner;

public class Mw_1912 {
    static int[] dp;
    static int[] arr;

    static void DP(int num) {
        dp[0] = arr[0];
        for(int idx = 1; idx < num; idx++) {
            if(dp[idx-1] + arr[idx] > arr[idx]) dp[idx] = dp[idx-1] + arr[idx];
            else dp[idx] = arr[idx];
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        arr = new int[n];
        dp = new int[n];

        for(int idx = 0; idx < n; idx++) {
            arr[idx] = sc.nextInt();
        }

        DP(n);
        Arrays.sort(dp);
        System.out.println(dp[n-1]);
    }
}
