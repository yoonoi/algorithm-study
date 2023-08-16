package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 오름차순
public class Yy_15650 {
	
	static int n, m;
	static int[] selected;
	static boolean[] used;
	
	static void permutation(int k) {
		// 선택 다 되믄 출력
		if(k == m) {
			for(int i=0; i<m; i++) {
				System.out.print(selected[i] + " ");
			}
			System.out.println();
			
			return;
		}
		
		for(int i=0; i<n; i++) {
			// 여기까지는 동일. 당연히 사용되지 않은 애들중에 골라야함!
			if(!used[i]) {
				// k == 0 : 제일 먼저 선택된 애는 15649번과 동일하게 풀이
				// k >= 1일땐 오름차순일때만 적용
				if(k == 0 || selected[k-1] < i+1) {
					selected[k] = i+1;
					used[i] = true;
					permutation(k+1);
					used[i] = false;					
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		selected = new int[m];
		used = new boolean[n];
		
		permutation(0);
	}
}
