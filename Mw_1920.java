package BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class Mw_1920 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] arr = new int[N];
		
		for(int idx = 0; idx < N; idx++) {
			arr[idx] = sc.nextInt(); 
		}
		
		// 이분탐색은 정렬된 상태에서만 사용할 수 있다.
		Arrays.sort(arr);
		
		int M = sc.nextInt();
		int[] find = new int[M];
		
		for(int idx = 0; idx < M; idx++) {
			find[idx] = sc.nextInt();
		}
		
		for(int idx = 0; idx < M; idx++) {
			if(BinarySearch(arr, find[idx]) == true) System.out.println(1);
			else System.out.println(0);
		}
	}
	// 이분탐색
	static boolean BinarySearch(int arr[], int num) {
		int left = 0;
		int right = arr.length - 1;
		int mid;
		
		while(left <= right) {
			mid = (left + right) / 2;
			if(arr[mid] < num) left = mid + 1;
			else if(arr[mid] > num) right = mid - 1;
			else return true;
		}
		return false;
	}
}
