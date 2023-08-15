import java.util.*;

public class Hw_25501 {
	static int count = 0; 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int testCase = sc.nextInt();
		sc.nextLine();
		for(int tc = 1; tc <= testCase; tc++) {
			String str = sc.nextLine();
			count = 1;
			
			if(isPalindrome(str, 0, str.length() - 1) == 1) {
				System.out.println(1 + " " + count);
			}
			else {
				System.out.println(0 + " " + count);
			}
		}
		
	}
	
	public static int isPalindrome(String str, int l, int r) {
		if(l >= r) {
			return 1;
		}
		else if(str.charAt(l) != str.charAt(r)) {
			return 0;
		}
		count++;
		return isPalindrome(str, l + 1, r - 1);
	}
}
