package recur;

import java.util.Scanner;

public class Yy_11729 {
	
	static int n, k;
	static StringBuilder sb = new StringBuilder();
	
	static int recur(int n) {
		// 종료조건
		if(n == 1) 
			return 1;
		
		// 반복절
		return 2 * recur(n-1) + 1;
	}
	
	static void recurPrint(int n, int start, int mid, int end) {
		
		if(n == 1) {
			sb.append(start).append(" ").append(end).append("\n");
			return;
		}
		
		recurPrint(n-1, start, end, mid);
		recurPrint(1, start, mid, end);
		recurPrint(n-1, mid, start, end);
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		k = 0;
		
		System.out.println(recur(n));
		recurPrint(n, 1, 2, 3);
		
		System.out.println(sb);
	}
}
