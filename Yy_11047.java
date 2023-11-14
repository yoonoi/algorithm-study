import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Yy_11047 {

    static int n, k;
    static int[] money;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        money = new int[n];

        for(int i=0; i<n; i++) {
            money[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(makePrice(k));
    }

    static int makePrice(int k) {
        int cnt = 0;

        // 큰 수부터
        for(int i=n-1; i>=0; i--) {
            cnt += k/money[i];
            k %= money[i];
        }

        return cnt;
    }

}
