import java.util.*;

public class Hw_12904 {
	static String S;
	static String T;
	static int result = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		S = sc.next();
		T = sc.next();

		while (T.length() > S.length()) {
			char lastChar = T.charAt(T.length() - 1);
			if (lastChar == 'A') {
				String tmpT = "";
				for (int i = 0; i < T.length() - 1; i++) {
					tmpT = tmpT + T.charAt(i);
				}
				T = tmpT;
			} else {
				String tmpT = "";
				for (int i = T.length() - 2; i >= 0; i--) {
					tmpT = tmpT + T.charAt(i);
				}
				T = tmpT;
			}
			System.out.println(T);
			if(T.equals(S)) {
				result = 1;
				break;
			}
		}

		System.out.println(result);
	}

//	public static void changeString(String str) {
//
//		if (str.length() > T.length()) {
//			return;
//		}
//		if (str.equals(T)) {
//			result = 1;
//			return;
//		}
//
//		changeString(addA(str));
//		changeString(reverseAndAddB(str));
//	}
//
//	public static String addA(String str) {
//		str = str + 'A';
//		return str;
//	}
//
//	public static String reverseAndAddB(String str) {
//		String str2 = "";
//		for (int i = str.length() - 1; i >= 0; i--) {
//			str2 = str2 + str.charAt(i);
//		}
//		str2 = str2 + 'B';
//		return str2;
//	}
}
