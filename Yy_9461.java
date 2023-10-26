import java.util.Scanner;

public class Yy_9461 {

    static StringBuilder sb = new StringBuilder();
    static int n;
    static long[] padoban; // 가장 큰 100넣어보니까 int 범위를 초과해서 long으로 변경

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc=0; tc<T; tc++) {
            n = sc.nextInt();
            padoban = new long[n+1];

            sb.append(p(n)).append("\n");
        }

        System.out.println(sb);

    }

    static long p(int n) {
        if(n <= 3) {
            for(int i=1; i<=n; i++)
                padoban[i] = 1;
        } else {
            padoban[1] = padoban[2] = padoban[3] = 1;
            for(int i=4; i<=n; i++) {
                padoban[i] = padoban[i-3] + padoban[i-2];
            }
        }

        return padoban[n];
    }

    // 재귀는 시간초과
//    static int p(int n) {
//        if(n <= 3)
//            return 1;
//
//        return p(n-3) + p(n-2);
//    }
}
