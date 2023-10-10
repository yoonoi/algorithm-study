package bonus;

import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Yy_2468 {

    static int n, maxHeight, maxSafeZone;
    static int[][] board;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        maxHeight = Integer.MIN_VALUE;
        maxSafeZone = 1;

        board = new int[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                board[i][j] = sc.nextInt();

                if(maxHeight < board[i][j])
                    maxHeight = board[i][j];
            }
        }

        for(int i=1; i<=maxHeight; i++) {
            int tmpCnt = checkArea(i);

            maxSafeZone = Math.max(maxSafeZone, tmpCnt);
        }

        System.out.println(maxSafeZone);
    }

    static int checkArea(int depth) {
        Queue<Point> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        int cnt = 0;

        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(isSafeZone(i, j, depth) && !visited[i][j]){
                    q.offer(new Point(i, j));
                    visited[i][j] = true;

                    boolean upCnt = false;
                    while(!q.isEmpty()) {
                        Point now = q.poll();
                        upCnt = true;

                        for(int k=0; k<4; k++) {
                            int nr = now.x + dr[k];
                            int nc = now.y + dc[k];

                            if(isOutOfRange(nr, nc)) continue;

                            if(!isSafeZone(nr, nc, depth)) continue;

                            if(visited[nr][nc]) continue;

                            q.offer(new Point(nr, nc));
                            visited[nr][nc] = true;
                        }
                    }

                    if(upCnt)
                        cnt++;
                }
            }
        }

        return cnt;
    }

    static boolean isSafeZone(int row, int col, int depth) {
        return board[row][col] > depth;
    }

    static boolean isOutOfRange(int row, int col) {
        return row < 0 || col < 0 || row >= n || col >= n;
    }
}
