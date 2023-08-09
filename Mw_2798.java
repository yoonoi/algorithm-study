package BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class Mw_2798 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 카드의 개수 N을 입력 받자.
		int N = sc.nextInt();
		// 카드 합의 최대값 M을 입력 받자.
		int M = sc.nextInt();
		
		// 배열을 만들어 카드에 적힌 수를 순서대로 입력 받자.
		int[] arr = new int[N];
		for(int idx = 0; idx < N; idx++) {
			arr[idx] = sc.nextInt();
		}
		// 배열을 순차적으로 정리하자.
		Arrays.sort(arr);
		
		// 카드 합을 나타내는 변수를 가장 작은 카드 세 장을 더한 값으로 초기화하여 선언하자.
		int sum = arr[0] + arr[1] + arr[2];
		
		// 3중 for문을 통해 조건에 맞는 수를 도출하고,
		for(int a = 0; a < N-2; a++) {
			for(int b = a+1; b < N-1; b++) {
				for(int c = b+1; c < N; c++) {
					if(sum <= M && arr[a] + arr[b] + arr[c] <= M && sum < arr[a] + arr[b] + arr[c]) {
						sum = arr[a] + arr[b] + arr[c];
					}
				}
			}
		}
		
		// 그 값을 출력하자. 
		System.out.println(sum);
	}
}