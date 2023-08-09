package silver;

import java.util.Scanner;

public class Kh_1436 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		
		int start = 665;
		int seq = 0;
		
		while(seq<N) {
			start++;
			if(Integer.toString(start).contains("666")) {
				seq++;
			}
		}
		System.out.println(start);
		

	}
}
