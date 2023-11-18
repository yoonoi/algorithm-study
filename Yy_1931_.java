package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/*
	
Comparator 사용하긔
https://ifuwanna.tistory.com/328

그리디
https://st-lab.tistory.com/145

 */
public class Yy_1931_ {
	
	static int n;
	static int[][] meeting; // 나는 시작시간 순으로 정렬했는데, 반대로 종료시간으로 정렬해야함
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		meeting = new int[n][2];
		
		StringTokenizer st;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<2; j++) {
				meeting[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 종료시간 순으로 오름차순
		// 종료시간이 같다면 시작시간 순으로 오름차순
		Arrays.sort(meeting, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] != o2[1])
					return o1[1] - o2[1]; // 종료시간 순으로 오름차순 
				
				return o1[0] - o2[0]; // 종료시간이 같다면 시작시간 순으로 오름차순
			}
		});
		
		System.out.println(checkEndTime());
	}
	
	static int checkEndTime() {
		
		int cnt = 0;
		int endTime = 0;
		
		for(int i=0; i<n; i++) {
			// 직전 종료시간이 다음 회의 시작 시간보다 작거나 같다면 갱신쓰
			if(endTime <= meeting[i][0]) {
				endTime = meeting[i][1];
				cnt++;
			}
		}
		
		return cnt;
	}
	
	
	
//	static int n, maxCnt;
//	static int[][] arr;
//	
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		n = Integer.parseInt(br.readLine());
//		arr = new int[n][2];
//		
//		StringTokenizer st;
//		for(int i=0; i<n; i++) {
//			st = new StringTokenizer(br.readLine());
//			for(int j=0; j<2; j++) {
//				arr[i][j] = Integer.parseInt(st.nextToken());
//			}
//		}
//		
//		// 1. 시작시간을 기준으로 오름차순 정렬을 한다.
//		Arrays.sort(arr, new Comparator<int[]>() {
//			@Override
//			public int compare(int[] o1, int[] o2) {
//				return o1[0] - o2[0]; // 첫번쨰 숫자 기준 오름차순
////				return o2[0] - o1[0]; // 첫번째 숫자 기준 내림차순
////				return o1[1] - o2[1]; // 두번째 숫자 기준 오름차순
////				return o2[1] - o1[1]; // 두번쨰 숫자 기준 내림차순
//			}
//		});
//		
//		
////		System.out.println(dp());
//		
////		for(int i=0; i<n; i++) {
////			recur(i, 1);
//			
////			if(n-i < maxCnt) break;
////		}
//		
////		System.out.println(maxCnt);
//	}
//	
//	static void recur(int idx, int cnt) {
////		System.out.println("idx : " + idx);
////		System.out.println("cnt : " + cnt);
//		
////		int start = arr[idx][0];
//		int end = arr[idx][1];
//		
//		for(int i=idx+1; i<n; i++) {
//			int nextStart = arr[i][0];
////			int nextEnd = arr[i][1];
//			
//			// 가능한 경우
//			if(nextStart >= end) 
//				recur(i, cnt+1);
//			
//		}
//		
//		if(cnt > maxCnt)
//			maxCnt = cnt;
//	}
//
//	// 해당 회의까지 가장 최대값 저장
//	static int dp() {
//		
//		int[] dp = new int[n];
//		dp[0] = 1; // 본인
//		
//		for(int i=1; i<n; i++) {
//			dp[i] = 1; // 본인
//			
//			for(int j=0; j<i; j++) {
//				if(arr[i][0] >= arr[j][1]) {
//					dp[i] = Math.max(dp[i], dp[j] + 1);
//				}
//			}
//		}
//		
////		System.out.println(Arrays.toString(dp));
//		
//		return dp[n-1];
//	}
}
