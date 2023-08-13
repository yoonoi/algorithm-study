package Bronze;

import java.util.Scanner;

public class kh_10872 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int fac = 1;
		for(int i = N ; i >= 1 ; i--) {
			fac *= i;
		}
		System.out.println(fac);
	}

}
