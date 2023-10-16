package gold;

import java.util.*;

public class Kh_2230_  {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		int[] seq = new int[N];

		for (int i = 0; i < N; i++) {
			seq[i] = sc.nextInt();
		}

		Arrays.sort(seq);

		int start = 0;
		int end = 0;
		int min = Integer.MAX_VALUE;

		while (start <= end && end < N) {
			int curDif = seq[end] - seq[start];
			if(curDif < M) {
				end++;
			}else {
				min = Math.min(curDif, min);
				start++;
			}
			
			if(curDif == M) {
				break;
			}
		}
		System.out.println(min);
	}
}
