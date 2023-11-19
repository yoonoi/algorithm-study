package greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Mw_1931 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[][] time = new int[N][2];
		
		for(int idx = 0; idx < N; idx++) {
			for(int jdx = 0; jdx < 2; jdx++) {
				time[idx][jdx] = sc.nextInt();
			}
		}
		
		// 시작시간은 [0], 종료시간은 [1]
		Arrays.sort(time, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				// 종료시간이 다르다면
				if(o1[1] != o2[1])
					return o1[1] - o2[1]; // 종료시간 기준으로 오름차순
//				return o2[1] - o1[1]; // 종료시간 기준으로 내림차순
//				return o2[0] - o1[0]; // 시작시간 기준으로 내림차순
				
				// 종료시간이 같다면 시작시간 순으로 오름차순
				return o1[0] - o2[0]; 
			}
		});
		
		int cnt = 0;
		int endTime = 0;
		for(int i=0; i<N; i++) {
			if(time[i][0] >= endTime) {
				endTime = time[i][1];
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
}
