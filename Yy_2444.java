package simhwa1;

import java.util.Scanner;

public class Yy_2444 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for(int i=0; i<n; i++) {
			// 공백
			for(int j=n-1; j>i; j--) {
				System.out.print(" ");
			}
			
			// 별
			for(int j=1; j<= 2*i+1; j++) {
				System.out.print("*");
			}
			
			System.out.println();
		}
		
		for(int i=0; i<n-1; i++) {
			// 공백
			for(int j=0; j<=i; j++) {
				System.out.print(" ");
			}
			
			// 별
			for(int j=2*(i+1); j<2*n-1; j++) {
				System.out.print("*");
			}
			
			System.out.println();
		}
	}
}
