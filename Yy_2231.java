package bruteforce;

import java.util.Scanner;

public class Yy_2231 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for(int i=1; i<n; i++) {
			int sum = i;
			int j = i;
			
			while(j > 0) {
				sum += j % 10;
				j /= 10;
			}
			
			if(sum == n) {
				System.out.println(i);
				return;
			}
		}
		
		System.out.println(0);
		
	}

}
