package BOJ;

import java.util.Scanner;

public class Mw_9184_ {
	static int a, b, c;
	static int[][][] dp = new int[21][21][21];
	
	public static int w(int a, int b, int c) {
		//BC
		if(a<=0 || b<=0 || c<=0) {
			return 1;
		}
		if(a>20 || b>20 || c>20) {
			return w(20, 20, 20);
		}

		//Memoization
		if(dp[a][b][c] != 0) {
			return dp[a][b][c];
		}
		
		//Condition1
		if(a<b && b<c) {
			dp[a][b][c] =  w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c);
			return dp[a][b][c];
		}
		
		//Condition2(otherwize)
		dp[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
		return dp[a][b][c];
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			a = sc.nextInt();
			b = sc.nextInt();
			c = sc.nextInt();
			
			if(a==-1 && b==-1 && c==-1) {
				break;
			}
			
			System.out.println("w("+a+ ", "+b+", "+c+") = " + w(a, b, c));
		}
	}
}
