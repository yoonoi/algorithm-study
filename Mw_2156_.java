package BOJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Mw_2156_ {

    static int n;
    static int[] dp, arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        dp = new int[n+1];
        arr = new int[n+1];

        for(int i=1; i<=n; i++)
            arr[i] = Integer.parseInt(br.readLine());

        drinkWine();
        System.out.println(maxDrink());
    }

    static void drinkWine() {
        dp[1] = arr[1];

        if(n >= 2)
            dp[2] = arr[1] + arr[2];

        // 해당 i칸을 무조건 먹어야하는 게 아니니까
        // i-1까지의 최대도 비교를 해줘야하는균
        for(int i=3; i<=n; i++)
            dp[i] = Math.max(Math.max(dp[i-2] + arr[i], dp[i-3] + arr[i-1] + arr[i]), dp[i-1]);
    }

    static int maxDrink() {
        int max = 0;

        for(int i=1; i<=n; i++)
            max = Math.max(max, dp[i]);

        return max;
    }
}