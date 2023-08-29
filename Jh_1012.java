import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Jh_1012 {
    static int row, col, cnt;
    static int [] dr= {-1,1,0,0}, dc= {0,0,-1,1};
    static int [][] map;
    static boolean [][] visited;
    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);

        int T=sc.nextInt();
        for(int tc=1; tc<=T; tc++) {
            cnt=0;
            row=sc.nextInt();
            col=sc.nextInt();

            map=new int [row][col];
            visited=new boolean[row][col];

            int k=sc.nextInt();
            //맵입력 완성
            for(int i=0;i<k; i++) {
                map[sc.nextInt()][sc.nextInt()]=1;
            }

            for(int r=0; r<row; r++) {
                for(int c=0; c<col; c++) {
                    if(map[r][c]==1&&!visited[r][c]) {
                        bfs(r,c);
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }

    static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {x,y});
        visited[x][y]=true;

        while(!queue.isEmpty()) {
            int newX,newY;
            int []poll=queue.poll();

            for(int i=0; i<4; i++) {
                newX=poll[0]+dr[i];
                newY=poll[1]+dc[i];

                if(newX<0||newX>=row||newY<0||newY>=col)
                    continue;
                if(map[newX][newY]==0||visited[newX][newY])
                    continue;

                queue.add(new int[] {newX,newY});
                visited[newX][newY]=true;
            }
        }
    }
}
