package recur;

import java.util.Scanner;

public class Yy_10870 {
	
	static int n;
	
	static int fibonacci(int k) {

		// 0이나 1일 땐 본인
		if(k == 0 || k == 1) {
			return k;
		}
		
		return fibonacci(k-1) + fibonacci(k-2);
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		System.out.println(fibonacci(n));
	}
}
