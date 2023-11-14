import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Yy_13305 {

    static long[] price, dist;
    static int n;
    static long money;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        dist = new long[n];
        price = new long[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<n; i++)
            dist[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)
            price[i] = Integer.parseInt(st.nextToken()); // 마지막 금액은 필요없엉

        // 최솟값 시작
        money = 0;

        buyOil();
    }

    static void buyOil() {
        long minPrice = Long.MAX_VALUE; // 현재의 최소금액 저장

        for(int i=0; i<n-1; i++) {
            minPrice = Math.min(minPrice, price[i]);

            // 다음 도시가 더 싸면 최소한만 산다
            money += minPrice * dist[i+1];

            if(i == n-2) continue;

            // 다음 도시에서 기름이 더 비싸면 이번에 다 사고 i를 패스해야함
            if(minPrice < price[i+1]) {
                money += minPrice * dist[i+2];
                i++;
            }
        }

        System.out.println(money);
    }

}
