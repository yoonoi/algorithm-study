import java.util.Scanner;

public class Kh_1806 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int S = sc.nextInt();

		int[] seq = new int[N];

		for (int i = 0; i < N; i++) {
			seq[i] = sc.nextInt();
			if (seq[i] >= S) {
				System.out.println(1);
				return;
			}
		}

		int start = 0;
		int end = 0;
		int min = N + 1;
		int sum = 0;
		for (int i = start; i <= end; i++) {
			sum += seq[i];
		}

		while (start <= end && end < N) {

			if (sum < S) {
				end++;
				if (end < N) {
					sum += seq[end];
				} else {
					break;
				}
			} else {
				min = Math.min(min, end - start + 1);
				start++;
				sum -= seq[start - 1];
			}
		}

		if (min == N + 1) {
			System.out.println(0);
		} else {
			System.out.println(min);
		}
	}
}
