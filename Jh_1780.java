import java.util.Scanner;
import java.util.StringTokenizer;

public class Jh_1780 {
    static int paper[][];
    static int cnt[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        paper = new int[n][n];
        cnt = new int[3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                paper[i][j] = sc.nextInt();
            }
        }
        go(0, 0, n);
        for (int i = 0; i < 3; i++) {
            System.out.println(cnt[i]);
        }
    }

    public static void go(int x,int y,int n) {
        if(check(x,y,n)) {
            cnt[paper[x][y]+1] += 1;
            return;
        }
        int m = n/3;
        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++) {
                go(x+i*m,y+j*m,m);
            }
        }
    }
    public static boolean check(int x, int y, int n) {
        for(int i=x;i<x+n;i++) {
            for(int j=y;j<y+n;j++) {
                if(paper[x][y]!=paper[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
