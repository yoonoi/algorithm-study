import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Jh_7569 {
    static int[] dx = { -1, 0, 1, 0, 0, 0 };
    static int[] dy = { 0, 1, 0, -1, 0, 0 };
    static int[] dz = { 0, 0, 0, 0, -1, 1 };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int h = sc.nextInt();

        Queue<Node3> queue = new LinkedList<Node3>();

        int[][][] arr = new int[h][n][m];
        int[][][] dist = new int[h][n][m];

        for (int k = 0; k < h; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    arr[k][i][j] = sc.nextInt();
                    if (arr[k][i][j] == 1)
                        queue.add(new Node3(k, i, j));
                }
            }
        }

        while (!queue.isEmpty()) {
            Node3 t = queue.remove();
            int x = t.x;
            int y = t.y;
            int z = t.z;
            for (int i = 0; i < dy.length; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nz = z + dz[i];

                if (0 <= nx && nx < h && 0 <= ny && ny < n && 0 <= nz && nz < m) {
                    if (arr[nx][ny][nz] == 0 && dist[nx][ny][nz] == 0) {
                        queue.add(new Node3(nx, ny, nz));
                        dist[nx][ny][nz] = dist[x][y][z] + 1;
                    }
                }
            }
        }

        int ans = 0;

        for (int k = 0; k < h; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (ans < dist[k][i][j])
                        ans = dist[k][i][j];
                }
            }
        }

        for (int k = 0; k < h; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (arr[k][i][j] == 0 && dist[k][i][j] == 0) {
                        ans = -1;
                    }
                }
            }
        }

        System.out.println(ans);
    }
}

class Node3 {
    int x;
    int y;
    int z;

    Node3(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
