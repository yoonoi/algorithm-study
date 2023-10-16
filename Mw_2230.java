package twoPointer;

import java.util.Arrays;
import java.util.Scanner;

public class Mw_2230 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[] arr = new int[N];
		
		for(int idx = 0; idx < N; idx++) {
			arr[idx] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		int start = 0;
		int end = 0;
		int answer = Integer.MAX_VALUE;
		
		while(start <= end && end < N) {
			if(arr[end] - arr[start] >= M) {
				answer = Math.min(answer, arr[end] - arr[start]);
				start++;
			}
			else end++;
		}
		
		System.out.println(answer);
	}
}
