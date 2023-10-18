import java.util.*;

public class Hw_1806 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int S = sc.nextInt();
		int[] arr = new int[N + 1];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		int left = 0, right = 0;
		int length = Integer.MAX_VALUE;
		int sum = arr[0];

		while (right < N) {
			if (sum >= S) {
				length = Math.min(length, right - left + 1);
				sum -= arr[left++];

			} else {
				sum += arr[++right];
			}

		}

		System.out.println(length == Integer.MAX_VALUE ? 0 : length);
	}
}
