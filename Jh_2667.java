import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Jh_2667 {
    static int n, cnt;
    static int[][] map;
    static ArrayList<Integer> result;
    static boolean[][] visited;
    static int[] dr = { -1, 1, 0, 0 }, dc = { 0, 0, -1, 1 };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        map = new int[n][n];
        visited = new boolean[n][n];
        result = new ArrayList<>();

        for(int r=0; r<n; r++) {
            String str=sc.next();
            for(int c=0; c<n; c++) {
                map[r][c]=str.charAt(c)-'0';
            }
        }

        for(int r=0; r<n; r++) {
            for(int c=0; c<n; c++) {
                if(map[r][c]==0||visited[r][c]) continue;
                cnt=0;
                dfs(r,c);
                result.add(cnt);
            }
        }
        Collections.sort(result);
        System.out.println(result.size());
        for(int a : result) {
            System.out.println(a);
        }
    }

    private static void dfs(int r, int c) {
        visited[r][c]=true;
        cnt++;
        for(int i=0; i<4; i++) {
            int curr= r+dr[i];
            int curc= c+dc[i];

            if(curr<0||curr>=n||curc<0||curc>=n) continue;
            if(map[curr][curc]==0||visited[curr][curc]) continue;
            dfs(curr,curc);
        }
    }
}
