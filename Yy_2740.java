import java.util.Scanner;

public class Yy_2740 {
	
	static int[][] a, b, c;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		a = new int[n][m];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				a[i][j] = sc.nextInt();
			}
		}
		
		sc.nextInt();
		int k = sc.nextInt();
		b = new int[m][k];
		for(int i=0; i<m; i++) {
			for(int j=0; j<k; j++) {
				b[i][j] = sc.nextInt();
			}
		}
		
		c = new int[n][k];
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				for(int l=0; l<k; l++) {
					c[i][l] += a[i][j] * b[j][l];
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<n; i++) {
			for(int j=0; j<k; j++) {
				sb.append(c[i][j]).append(" ");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);		
	}
}
