package Bronze;

import java.util.Scanner;

public class Kh_2444 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		for(int i = 1; i <= 2*N-1 ; i++) {
			int order = Math.abs(N-i);
			int asteriskNum = 2*(N-order)-1;
			blank(order);
			asterisk(asteriskNum);
			System.out.println();
		}
	}
	
	public static void blank(int a) {
		for(int i = 0 ; i < a ; i++) {
			System.out.print(" ");
		}
	}
	public static void asterisk(int b) {
		for(int i = 0 ; i < b ; i++) {
			System.out.print("*");
		}
	}
}
