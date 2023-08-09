import java.util.*;

public class Hw_1157 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		String str = sc.next();
		int[] count = new int[26];
		int result = Integer.MIN_VALUE;
		int resultIdx = 0;
		boolean flag = true;

		for (int i = 0; i < str.length(); i++) {
			char alphabet = str.charAt(i);

			if (alphabet >= 97) {
				count[alphabet - 97]++;
				continue;
			}

			count[alphabet - 65]++;

		}

		for (int i = 0; i < 26; i++) {
			if(result <= count[i]) {
				if(result == count[i]) {
					flag = false;
				}
				else {
					flag = true;
				}
				result = count[i];
				resultIdx = i;
			}
		}

		if (flag) {
			System.out.println((char) (resultIdx + 'A'));
			
		} else {
			System.out.println("?");
		}
	}
}
