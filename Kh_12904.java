import java.util.Scanner;

public class Kh_12904 {
	static String S, T;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		S = sc.next();
		T = sc.next();

		op(T.length() - S.length());

	}

	public static void op(int difference) {
		while (difference > 0) {
			if (T.charAt(T.length() - 1) == 'B') {
				reverseFlipAddB();
				difference--;
			} else if (T.charAt(T.length() - 1) == 'A') {
				reverseAddA();
				difference--;
			}
			if (difference == 0) {
				if(isSame(S, T)) {
					System.out.println(1);
				}else {
					System.out.println(0);
				}
				return;
			}
		}

	}

	public static boolean isSame(String s, String t) {

		if (s.equals(t)) {
			return true;
		}
		return false;
	}

	public static void reverseAddA() {
		String tmp = "";
		for (int i = 0; i < T.length() - 1; i++) {
			tmp += T.charAt(i);
		}
		T = tmp;
	}

	public static void reverseFlipAddB() {

		String tmp = "";
		for (int i = T.length() - 2; i >= 0; i--) {
			tmp += T.charAt(i);
		}
		T = tmp;
	}
}
