import java.util.*;

public class Hw_2839 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int kg5 = N / 5;
		int kg3 = 0;
		int rest;
		while (kg5 >= 0) {
			rest = N - kg5 * 5;
			kg3 = rest / 3;
			if (rest % 3 == 0) {
				break;
			}
			kg5--;
		}
		if (kg5 < 0) {
			System.out.println(-1);
		} else {

			System.out.println(kg5 + kg3);
		}
	}
}
