package BOJ;

import java.util.Scanner;

public class Mw_24416 {
	static int cnt1, cnt2 = 0;
	
	static int fib(int num) {
		if(num == 1 || num == 2) {
			cnt1++;
			return 1;
		}
		return fib(num -1) + fib(num -2);
	}
	
	static int[] f;
	
	static int fibonacci(int num) {
		f[1] = 1;
		f[2] = 1;
		for(int idx = 3; idx <= num; idx++) {
			cnt2++;
			f[idx] = f[idx - 1] + f[idx - 2];
		}
		return f[num];
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		f = new int[n+1];
		
		fib(n);
		fibonacci(n);
		
		System.out.println(cnt1 + " " + cnt2);
	}
}
