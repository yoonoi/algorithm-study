package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Yy_15649 {
	
	static int n, m;
	static int[] selected; 
	static boolean[] used;
	
	// 수열 nPr
	static void permutation(int n, int r, int depth) {
		// 종료조건
		if(depth == m) {
			
			for(int i=0; i<r; i++) {
				System.out.print(selected[i] + " ");
			}
			System.out.println();
			
			return;
		}
		
		// 반복절
		for(int i=0; i<n; i++) {
			// 사용 안됐으면 
			if(!used[i]) {
				used[i] = true; // 사용해주고
				selected[depth] = i + 1; // 수열에 넣어준다.
				
				permutation(n, r, depth+1);
				used[i] = false; // 미사용으로 백트래킹
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
		
		permutation(n, m, 0);
	}
}
