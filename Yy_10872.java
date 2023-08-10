package combinatorics;

import java.util.Scanner;

public class Yy_10872 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int answ = 1;
		for(int i=1; i<=n; i++) 
			answ *= i;
		
		System.out.println(answ);
		
	}
}
