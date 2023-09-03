import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Jh_2206 {

    static int[] dx = { 1, 0, -1, 0 };
    static int[] dy = { 0, 1, 0, -1 };
    static int n, m;
    static int[][] map;
    static boolean[][][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        sc.nextLine();

        map = new int[n][m];
        for (int i = 0; i < n ; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.valueOf(str.charAt(j)) - '0';
            }
        }

        visited = new boolean[n][m][2];
        System.out.println(bfs(0, 0));
    }

    private static int bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y, 1, 0));
        visited[x][y][0] = true;
        visited[x][y][1] = true;

        while (!q.isEmpty()) {
            Node current = q.poll();

            if (current.x == n - 1 && current.y == m - 1) return current.cnt;

            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if(map[nx][ny] == 0) {
                        if (visited[nx][ny][current.wall] == false) {
                            q.add(new Node(nx, ny, current.cnt + 1, current.wall));
                            visited[nx][ny][current.wall] = true;
                        }
                    }
                    else if (map[nx][ny] == 1) {
                        if (current.wall == 0 && visited[nx][ny][1] == false) {
                            q.add(new Node(nx, ny, current.cnt + 1, 1));
                            visited[nx][ny][1] = true;
                        }
                    }
                }
            }
        }
        return -1;
    }

    private static class Node {
        private int x;
        private int y;
        private int cnt;
        private int wall;

        public Node(int x, int y, int cnt, int wall) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.wall = wall;
        }
    }
}
