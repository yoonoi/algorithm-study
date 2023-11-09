import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Yy_1932 {

    static int n;
    static int[][] triangle, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        triangle = new int[n][n];
        dp = new int[n][n];
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<=i; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = triangle[i][j];
            }
        }

//        for(int i=0; i<n; i++) {
//            System.out.println(Arrays.toString(triangle[i]));
//        }

        System.out.println(findMaxSum());
    }

    // 아래에서 위로 반대로올라가기~!
    static int findMaxSum() {
        for(int i=1; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(j == 0) {
                    dp[i][j] += dp[i-1][j];
                    continue;
                }

                if(j == n-1) {
                    dp[i][j] += dp[i-1][j-1];
                    continue;
                }

                dp[i][j] += Math.max(dp[i-1][j-1], dp[i-1][j]);
            }
        }

//        for(int i=0; i<n; i++) {
//            System.out.println(Arrays.toString(dp[i]));
//        }

        int max = 0;
        for(int i=0; i<n; i++)
            max = Math.max(max, dp[n-1][i]);

        return max;
    }

}
