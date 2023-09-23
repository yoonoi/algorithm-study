import java.util.Arrays;
import java.util.Scanner;

public class Kh_3273 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[] numbers = new int[N];

		for (int i = 0; i < N; i++) {
			numbers[i] = sc.nextInt();
		}
		Arrays.sort(numbers);

		int K = sc.nextInt();

		int count = 0;
		int left = 0;
		int right = N-1;
		
		while (left<right) {
			int tmpSum = numbers[left] + numbers[right];
			if (tmpSum == K) {
				count++;
				left++;
				right--;
			} else if (tmpSum < K) {
				left++;
			} else if(tmpSum > K) {
				right--;
			}

		}

		System.out.println(count);

	}

}
