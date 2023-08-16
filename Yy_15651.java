package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 오름차순
public class Yy_15651 {
	
	static int n, m;
	static int[] selected;
	
	static StringBuilder sb = new StringBuilder();
	
	static void permutation(int k) {
		
		if(k == m) {
			for(int i=0; i<m; i++) {
				sb.append(selected[i]).append(" ");
			}
			sb.append("\n");
			
			return;
		}
		
		for(int i=0; i<n; i++) {
			selected[k] = i+1;
			permutation(k+1);
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		selected = new int[m];
		
		permutation(0);
		System.out.println(sb);
	}
}
