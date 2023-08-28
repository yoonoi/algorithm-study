import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Jh_2606 {
    static int n, m, cnt;
    static boolean[] visited;
    static int[][] map;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        cnt=0;
        n = sc.nextInt();
        m = sc.nextInt();

        visited = new boolean[n+1];
        map = new int[n+1][n+1];

        for (int i=0;i<m; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            map[a][b] = map[b][a] = 1;
        }
        bfs(1);
        System.out.println(cnt);
    }

    private static void bfs(int v){
        Queue<Integer> q = new LinkedList<>();

        q.add(v);
        visited[v] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i = 1; i <= n; i++) {
                if (map[cur][i] == 1 && !visited[i]) {
                    q.add(i);
                    visited[i] = true;
                    cnt++;
                }
            }
        }
    }
}
