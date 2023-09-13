package BOJ;

import java.util.Arrays;
import java.util.Scanner;

public class Mw_10816_ {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] arr = new int[N];
		
		for(int idx = 0; idx < N; idx++) {
			arr[idx] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		
		int M = sc.nextInt();
		StringBuilder sb = new StringBuilder();
		
		for(int idx = 0; idx < M; idx++) {
			int target = sc.nextInt();
			sb.append(upperBound(arr, target) - lowerBound(arr, target)).append(' ');
        }
        System.out.println(sb);
    }
	private static int lowerBound(int[] arr, int target) {
        int low = 0;
        int high = arr.length;

        while (low < high) {
            int mid = (low + high) / 2;
            if (target <= arr[mid]) {
                high = mid;
            }
            else {
                low = mid + 1;
            }
        }
        return low;
    }
    private static int upperBound(int[] arr, int target) {
        int low = 0;
        int high = arr.length;

        while (low < high) {
            int mid = (low + high) / 2;
            if (target < arr[mid]) {
                high = mid;
            }
            else {
                low = mid + 1;
            }
        }
        return low;
    }
}
