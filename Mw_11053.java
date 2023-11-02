package BOJ;

//import java.util.Arrays;
import java.util.Scanner;

public class Mw_11053 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] A = new int[N];
		for(int idx = 0; idx < N; idx++) {
			A[idx] = sc.nextInt();
		}
		
		// 해당 수를 기준으로 만들 수 있는 가장 긴 수열의 값을 저장할 배열 arr.
		int[] arr = new int[N];
		for(int idx = 0; idx < N; idx++) {
			arr[idx] = 1;
		}
		int max = 1;
		// 맨 뒤부터 탐색한다.
		for(int idx = N-2; idx >= 0; idx--) { 
			for(int jdx = idx+1 ; jdx < N; jdx++) {
				// 다음 수와 비교했을 때, 크기가 작으면서, 저장된 수열의 길이가 짧거나 같다면 값을 갱신하자.
				if(A[idx] < A[jdx] && arr[idx] <= arr[jdx]) arr[idx] = arr[jdx] + 1;
				if(max < arr[idx]) max = arr[idx];
			}
		}
//		System.out.println(Arrays.toString(arr));
		System.out.println(max);
	}
}
