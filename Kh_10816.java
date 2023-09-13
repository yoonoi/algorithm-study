import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Kh_10816 {
	static int N, M;
	static int[] cards;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		
		N = sc.nextInt();
		
		cards = new int[20000001];
		
		
		for(int i = 0 ; i < N ; i++) {
			cards[sc.nextInt()+10000000]++;
		}
		
		
		M = sc.nextInt();
		
		for(int i = 0 ; i < M ; i++) {
			int subject = sc.nextInt();
			
			sb.append(cards[subject+10000000]).append(" ");
		}
		System.out.println(sb);
	}
}
