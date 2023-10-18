package BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class Mw_1806 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int S = sc.nextInt();
		
		int[] arr = new int[N];
		int[] prefix = new int[N+1]; // 누적합을 저장할 배열 prefix.
		
		for(int idx = 0; idx < N; idx++) {
			arr[idx] = sc.nextInt();
		}
		
		// prefix 배열을 채워주자.
		for(int idx = 1; idx <= N; idx++) {
			prefix[idx] = prefix[idx - 1] + arr[idx - 1]; 
		}
		
		int start = 0;
		int end = 1;
		int length = Integer.MAX_VALUE;
		
		while(start < end && end <= N) {
			if(prefix[end] - prefix[start] >= S) {
				if(length > end - start)
				length = end - start;
				start++;
			} else end++;
		}
		
		// 삼항연산자를 사용하여 출력하자.
		System.out.println(length == Integer.MAX_VALUE ? 0 : length);
	}
}
