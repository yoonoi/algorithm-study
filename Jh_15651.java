import java.util.Scanner;

public class Jh_15651 {
    static int n, m;
    static int[] arr;
    static StringBuilder sb;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sb = new StringBuilder();

        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[m];

        mutiPermutation(0);
        System.out.println(sb);
    }

    static void mutiPermutation(int cnt) {
        if (cnt == m) {
            for (int a : arr) {
                sb.append(a + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            arr[cnt] = i + 1;
            mutiPermutation(cnt + 1);
        }
    }
}