import java.util.*;

public class Hw_2798 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] deck = new int[N];

		for (int i = 0; i < N; i++) {
			deck[i] = sc.nextInt();
		}
		
		int sum = 0;
		int result = 0;
		for (int i = 0; i < N - 2; i++) {
			for (int j = i + 1; j < N - 1; j++) {
				for (int k = j + 1; k < N; k++) {
					sum = deck[i] + deck[j] + deck[k];
					if(sum > M) {
						continue;
					}
					else if(M - sum < M - result) {
						result = sum;
					}
					
				}
			}
		}
		
		System.out.println(result);
	}
}
