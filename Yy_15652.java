package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 비내림차순
// 중복 가능 => used 필요없음
// 15650 + 15651
public class Yy_15652 {
	
	static int n, m;
	static int[] selected;
	
	static void permutation(int k) {
		
		if(k == m) {
			for(int i=0; i<m; i++) {
				System.out.print(selected[i] + " ");
			}
			System.out.println();
			
			return;
		}
		
		// 중복가능하니까 사용했는지(used) 확인할 필요 없고
		// 15650과 동일하게 진행
		for(int i=1; i<=n; i++) {
			if(k == 0 || selected[k-1] <= i) {
				selected[k] = i;
				permutation(k+1);
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		selected = new int[m];
		
		permutation(0);
	}
}
