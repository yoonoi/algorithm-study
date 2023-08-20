package silver;

import java.util.Scanner;

public class Kh_15652 {
	static int n,m, start;
	static int[] result;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		result = new int[m];
		start = 1;
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
		
		for(int i = start; i <= n ; i++) {
			result[idx] = i;
			start = i;
			permutation(idx+1);
			
		}
		
	}

}
