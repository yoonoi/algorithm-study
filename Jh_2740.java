import java.util.Scanner;

public class Jh_2740 {
    static int n,m,k;
    static int [][] a, b , result;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        a = new int[n][m];
        for(int r=0; r<n; r++) {
            for(int c=0; c<m; c++){
                a[r][c] = sc.nextInt();
            }
        }

        m = sc.nextInt();
        k = sc.nextInt();
        b = new int[m][k];
        for(int r=0; r<m; r++) {
            for(int c=0; c<k; c++){
                b[r][c] = sc.nextInt();
            }
        }

        result = new int[n][k];
        for(int r=0; r<n; r++) {
            for(int c=0; c<k; c++){
                for(int i=0; i<m; i++) {
                    result[r][c] += a[r][i] *b[i][c];
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int r=0; r<n; r++) {
            for(int c=0; c<k; c++){
                sb.append(result[r][c]).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
