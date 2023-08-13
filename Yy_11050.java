package combinatorics;

import java.util.Scanner;

public class Yy_11050 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int answ = 1;
		for(int i=n, cnt=1; cnt <=k; i--, cnt++) {
			answ *= i;
			answ /= cnt;
		}
		
		System.out.println(answ);
		
	}
}
