import java.util.Scanner;

public class Jh_15651 {
    static int n, m;
    static int[] pick;
    static StringBuilder sb;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sb = new StringBuilder();
        n = sc.nextInt();
        m = sc.nextInt();

        pick = new int[m];
        backtrackting(0);
        System.out.println(sb);
    }

    private static void backtrackting(int dep) {
        if (dep == m) {
            for (int p : pick) {
                sb.append(p).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 1; i <= n; i++) {
            pick[dep] = i;
            backtrackting(dep + 1);
        }
    }
}
