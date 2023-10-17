package dp;

import java.util.Scanner;

public class Yy_24416 {
	
	static int n;
	static int[] arr;
	static int cnt1, cnt2;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new int[n+1];
		
		cnt1 = 0;
		cnt2 = 0; 
		
		fib(n);
		fibonacci(n);
		
		System.out.println(cnt1 + " " + cnt2);
	}
	
	// recur - 재귀는 arr[n]번만큼 돎
	static int fib(int k) {
		if(k == 1 || k == 2) {
			cnt1++;
			return 1; // 코드 1
		}
		
		return fib(k-1) + fib(k-2);
	}
	
	// dp - n-2번만큼 돎
	static int fibonacci(int k) {
		arr[1] = 1;
		arr[2] = 1;
		
		for(int i=3; i<=n; i++) {
			arr[i] = arr[i-1] + arr[i-2]; // 코드2
			cnt2++;
		}
		
		return arr[k];
	}

}
