import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Jh_1926 {
    static int n, m, max, cnt;

    static int[][] drawing;
    static boolean[][] checked;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,1,-1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        max = 0;
        drawing = new int[n][m];
        checked = new boolean[n][m];
        for (int r=0; r < n; r++){
            for(int c=0; c<m; c++){
                drawing[r][c] = sc.nextInt();
            }
        }
        bfs();
        System.out.println(cnt);
        System.out.println(max);
    }

    static void bfs(){
        Queue<int[]> q = new LinkedList<>();

        for (int r=0; r<n; r++){
            for(int c=0; c<m; c++){

                if(drawing[r][c] ==1 && !checked[r][c]){
                    q.add(new int[]{r,c});
                    checked[r][c]=true;
                    cnt++;

                    int wid = 0;

                    while (!q.isEmpty()){
                        int[] cur = q.poll();
                        wid++;

                        for(int i=0; i<4; i++){
                            int newX = cur[0]+dx[i];
                            int newY = cur[1]+dy[i];

                            if(newX<0||newX>n-1||newY<0||newY>m-1)
                                continue;

                            if (drawing[newX][newY]==1 && !checked[newX][newY]) {
                                q.add(new int[]{newX, newY});
                                checked[newX][newY] = true;
                            }
                        }
                    }

                    max = Math.max(max, wid);
                }
            }
        }
    }
}
