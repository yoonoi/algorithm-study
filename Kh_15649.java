package silver;

import java.util.Scanner;

public class Kh_15649 {
	static int n,m;
	static int[] result;
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		
		result = new int[m];
		visited = new boolean[n+1];
		
		permutation(0);
		
	}
	
	public static void permutation(int k) {
		if(k==m) {
			for(int r : result) {
				System.out.print(r + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = 1; i <= n ; i++) {
			if(!visited[i]) {
				result[k] = i;
				visited[i] = true;
				permutation(k+1);
				visited[i] = false;
			}
		}
		
	}
}
