package BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class Mw_2470 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] arr = new int[N];

		for (int idx = 0; idx < N; idx++) {
			arr[idx] = sc.nextInt();
		}

		Arrays.sort(arr);

		int start = 0;
		int end = N - 1;
		int answer = Integer.MAX_VALUE;
		int startNum = Integer.MIN_VALUE;
		int endNum = Integer.MAX_VALUE;

		while (start < end) {
			int sum = arr[start] + arr[end];
			if(Math.abs(sum) < Math.abs(answer)) {
        		answer = sum;
        		startNum = arr[start];
        		endNum = arr[end];
			}
			
			if (sum == 0) {
				break;
			} else if (sum < 0) {
				start++;
			} else {
				end--;
			}

		}
		System.out.println(startNum + " " + endNum);
	}
}
