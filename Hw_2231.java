import java.util.*;

public class Hw_2231 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int minCreator = 0;
		int num = 1;

		while (num < N) {
			int sum = num;
			String numString = Integer.toString(num);
			
			for (int i = 0; i < numString.length(); i++) {
				sum += numString.charAt(i) - '0';
			}
			if (sum == N) {
				minCreator = num;
				break;
			}
			num++;
		}

		System.out.print(minCreator);
	}
}
