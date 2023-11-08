import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Yy_1149 {

    static int n;
    static int[][] prices, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        prices = new int[n][3];
        dp = new int[n][3];

        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<3; j++) {
                prices[i][j] = Integer.parseInt(st.nextToken());

                if(i == 0)
                    dp[i][j] = prices[i][j];
            }
        }

        for(int i=1; i<n; i++)
            Arrays.fill(dp[i], Integer.MAX_VALUE);

        System.out.println(makeDp());
    }

    static int makeDp() {
        for(int i=1; i<n; i++) {
            for(int j=0; j<3; j++) {
                // 내 하나 전 체크
                for(int k=0; k<3; k++) {
                    if(j == k) continue;

                    dp[i][j] = Math.min(dp[i-1][k] + prices[i][j], dp[i][j]);
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for(int i=0; i<3; i++)
            min = Math.min(min, dp[n-1][i]);

        return min;
    }

}
