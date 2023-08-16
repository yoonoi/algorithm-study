import java.util.Scanner;

public class Jh_15652 {
    static int n, m;
    static int[] arr;
    static StringBuilder sb;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sb = new StringBuilder();

        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[m];

        mutiCombi(0, 1);
        System.out.println(sb);
    }

    static void mutiCombi(int cnt, int k) {
        if (cnt == m) {
            for (int a : arr) {
                sb.append(a + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = k; i <= n; i++) {
            arr[cnt] = i;
            mutiCombi(cnt + 1, i);
        }
    }
}