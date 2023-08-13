import java.util.*;

public class Hw_10872 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int factorial = 1;
		
		for(int i = 2; i <= N; i++) {
			factorial *= i;
		}
		
		System.out.println(factorial);
	}
}
