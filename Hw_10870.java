import java.util.*;

public class Hw_10870 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println(fibonaci(sc.nextInt()));
		
	}
	
	public static int fibonaci(int n) {
		if(n == 1) {
			return 1;
		}
		else if(n  == 0) {
			return 0;  
		}
		return fibonaci(n - 1) + fibonaci(n - 2);
		
	}
}
