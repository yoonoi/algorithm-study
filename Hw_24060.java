import java.util.*;

public class Hw_24060 {
	static int[] sorted;
	static int count = 0;
	static int K;

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		K = sc.nextInt();
		int[] arr = new int[N];
		sorted = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		mergeSort(arr, 0, N - 1);

		if (count < K) {
			System.out.println(-1);
		}

	}

	public static void mergeSort(int[] arr, int left, int right) {
		int mid = (left + right) / 2;

		if (left == right) {
			return;
		}

		mergeSort(arr, left, mid);
		mergeSort(arr, mid + 1, right);

		merge(arr, left, mid, right);
	}

	public static void merge(int[] arr, int left, int mid, int right) {
		int l = left;
		int r = mid + 1;
		int idx = left;

		while (l <= mid && r <= right) {
			if (arr[l] <= arr[r]) {
				sorted[idx] = arr[l];
				count++;
				if (checkcount(arr[l])) {
					return;
				}
				idx++;
				l++;

			} else {
				sorted[idx] = arr[r];
				count++;
				if (checkcount(arr[r])) {
					return;
				}
				idx++;
				r++;
			}
		}

		if (r > right) {
			while (l <= mid) {
				sorted[idx] = arr[l];
				count++;
				if (checkcount(arr[l])) {
					return;
				}
				idx++;
				l++;
			}
		} else {
			while (r <= right) {
				sorted[idx] = arr[r];
				count++;
				if (checkcount(arr[r])) {
					return;
				}
				idx++;
				r++;
			}
		}

		for (int i = left; i <= right; i++) {
			arr[i] = sorted[i];
		}
	}

	public static boolean checkcount(int num) {
		if (count == K) {
			System.out.println(num);
			return true;
		}
		return false;
	}
}
