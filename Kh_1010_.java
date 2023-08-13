package silver;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Kh_1010_ {
	static int N,M;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int testCase = sc.nextInt();
		
		for(int tc = 0 ; tc < testCase ; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			System.out.println(combination());
		}
		
		
		
		
		
	}
	public static BigInteger combination( ) {
		return factorial(M).divide(factorial(N).multiply(factorial(M-N)));
	}

	public static BigInteger factorial(int n) {
		
		BigInteger fac = new BigInteger("1");

		for(int i = n ; i >= 1 ; i--) {
			fac = fac.multiply(new BigInteger(Integer.toString(i)));
		}

		return fac;
	}
}
