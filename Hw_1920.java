import java.util.*;

public class Hw_1920 {
	static int[] result;
	static int N;
	static int M;
	static int[] arr;
	static int[] arr2;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		M = sc.nextInt();
		arr2 = new int[M];
		result = new int[M];
		for (int i = 0; i < M; i++) {
			arr2[i] = sc.nextInt();
			binary(arr2[i], 0, N - 1, i);
			System.out.println(result[i]);
		}

	}

	public static void binary(int num, int start, int end, int idx) {
		int mid = (start + end) / 2;
		if (arr[mid] == num) {
			result[idx] = 1;
			return;
		}
		if (start >= end) {
			result[idx] = 0;
			return;
		}
		if (arr[mid] < num) {
			binary(num, mid + 1, end, idx);
			return;
		} else if (arr[mid] > num) {
			binary(num, start, mid, idx);
			return;
		}
	}
}