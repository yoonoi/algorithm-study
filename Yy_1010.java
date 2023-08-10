package combinatorics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Yy_1010 {
	
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	static int n, m, cnt;
	
	// mCn 구하기(조합)
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=t; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken()); // 서쪽
			m = Integer.parseInt(st.nextToken()); // 동쪽
			cnt = 1;
			
			for(int i=m, j=1; j<=n; i--, j++) {
				cnt *= i;
				cnt /= j;
			}
			
			sb.append(cnt).append("\n");
		}
		
		System.out.println(sb);
	}
}


// 조합 방식으로 풀기(시간초과)
//public class Yy_1010_조합_ {
//	
//	static StringBuilder sb = new StringBuilder();
//	static StringTokenizer st;
//	static int N, M, cnt;
//	static int[] selected;
//	
//	/**
//	 * nCr 조합 구하기
//	 * n개 중에 r개를 순서없이 골라내기
//	 */
//	static void combination(int n, int r) {
//		// 종료 조건
//		// N개를 다 골랐을 때
//		if(r == N) {
////			System.out.println(Arrays.toString(selected));
//			cnt++;
//			return;
//		}
//		
//		// M개 중에 M개 다 고려했을 때
//		if(n == M) return ;
//		
//		// 반복절
//		selected[r] = n;	   // 조합 배열에 넣어주고
//		combination(n+1, r+1); // 기존 배열에서 뽑을 때
//		combination(n+1, r);   // 기존 배열에서 안뽑을 때
//	}
//	
//	// mCn 구하기(조합)
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int t = Integer.parseInt(br.readLine());
//		
//		for(int tc=1; tc<=t; tc++) {
//			st = new StringTokenizer(br.readLine());
//			N = Integer.parseInt(st.nextToken()); // 서쪽
//			M = Integer.parseInt(st.nextToken()); // 동쪽
//			
//			selected = new int[N]; // N개 골라서 넣을 배열
//			
//			combination(0, 0);
//			sb.append(cnt).append("\n");
//		}
//		
//		System.out.println(sb);
//	}
//}
