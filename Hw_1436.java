import java.util.*;

public class Hw_1436 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int count = 0;
		int num = 666;
		String str = "";
		while (true) {
			str = str.valueOf(num);
			
			if(str.contains("666")) {
				count++;
			}
			if(count == N) {
				System.out.println(num);
				break;
			}
			num++;
		}
	}
}
