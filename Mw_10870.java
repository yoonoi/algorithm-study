package BOJ;

import java.util.Scanner;

public class Mw_10870 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		System.out.println(pibonacci(n));
	}

	// 피보나치를 재귀함수로 나타내보자.
	public static int pibonacci(int num) {
		if (num == 0) {
			return 0;
		} else if (num == 1) {
			return 1;
		} else {
			return pibonacci(num - 2) + pibonacci(num - 1);
		}
	}
}
