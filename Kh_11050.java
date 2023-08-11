package Bronze;

import java.util.Scanner;

public class Kh_11050 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(combination(sc.nextInt(), sc.nextInt()));

	}

	public static int combination(int n, int r) {
		if (n == r || r == 0) {
			return 1;
		}
		return combination(n-1, r) + combination(n-1, r-1);
	}

}
