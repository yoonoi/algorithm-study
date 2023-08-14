package Bronze;

import java.util.Scanner;

public class Kh_25501 {
	static int count;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 0 ; tc < T ; tc++) {
			count = 0;
			
			String word = sc.next();
			
			System.out.printf("%d %d",isPalindrome(word), count );
			System.out.println();
		}
	}
	public static int recur(String str, int s, int e) {
		count++;
		if(s >= e) {
			return 1;
		}else if(str.charAt(s) != str.charAt(e)) {
			return 0;
		}
		return recur(str, s+1, e-1);
	}
	
	public static int isPalindrome(String str) {
		return recur(str, 0, str.length()-1);
	}	
}
