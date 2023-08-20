package silver;

import java.util.Scanner;

public class Kh_15651 {
	static int n,m;
	static int[] result;
//	static boolean[] visited;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		result = new int[m];
		
		permutation(0);
		
		System.out.println(sb);
	}
	
	public static void permutation(int idx) {
		if(idx == m) {
			for(int r : result) {
				sb.append(r).append(" ");
			}
			sb.append('\n');
			return;
		}
		
		for(int i = 1; i <= n ; i++) {
			result[idx] = i;
			permutation(idx+1);
			
		}
		
	}

}
