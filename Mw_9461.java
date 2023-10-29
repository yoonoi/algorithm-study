import java.util.Scanner;

public class Mw_9461 {

    static StringBuilder sb = new StringBuilder();
    static int n;
    static long[] padoban; 

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc=0; tc<T; tc++) {
            n = sc.nextInt();
            padoban = new long[n+1];
	    p(n);
            sb.append(padaban[n]).append("\n");
        }

        System.out.println(sb);

    }

    static void p(int n) {
        if(n <= 3) {
            for(int i=1; i<=n; i++)
                padoban[i] = 1;
        } else {
            padoban[1] = padoban[2] = padoban[3] = 1;
            for(int i=4; i<=n; i++) {
                padoban[i] = padoban[i-3] + padoban[i-2];
            }
        }
    }

}
