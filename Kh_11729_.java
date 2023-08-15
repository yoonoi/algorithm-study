package silver;

import java.util.Scanner;

public class Kh_11729_ {
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int K = (int)Math.pow(2, N)-1;
		
		hanoi(N, 1, 2,3);
		
		System.out.println(K);
		
		System.out.println(sb);
	}
	
	public static void hanoi(int N, int start, int mid, int to) {
		if(N==1) {
			sb.append(start + " " + to +"\n");
			return;
		}
		
		hanoi(N-1, start, to, mid);
		
		sb.append(start + " " + to +"\n");
		
		hanoi(N-1, mid, start, to);
	}
	
}
