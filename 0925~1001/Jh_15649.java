import java.util.Scanner;

public class Jh_15649 {

    static int n, m;
    static int[] pick;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        pick = new int[m];
        visited = new boolean[n + 1];

        backtracting(0);
    }

    private static void backtracting(int dep) {
        if (dep == m) {
            for (int a : pick) {
                System.out.print(a + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 1; i <= n; i++) {
            if(!visited[i]) {
                pick[dep] = i;
                visited[i] = true;
                backtracting(dep + 1);
                visited[i] = false;
            }
        }
    }
}