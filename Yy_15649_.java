package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Yy_15649 {
	
	static int n, m;
	static int[] selected; 
	static boolean[] used;
	
	static void permutation(int k) {
		if(k == m) {
			for(int i=0; i<m; i++) {
				System.out.print(selected[i] + " ");
			}
			System.out.println();
			
			return;
		}
		
		for(int i=0; i<n; i++) {
			if(!used[i]) {
				selected[k] = i + 1;
				used[i] = true; 
				permutation(k+1);
				used[i] = false;
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		selected = new int[m]; // m개를 선택해서 수열을 넣을 배열
		used = new boolean[n]; // 1 ~ n의 수가 사용되었는지 체크
		
		permutation(0);
	}
}
