package Bronze;

import java.util.Scanner;

public class Kh_2798 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[] cards = new int[N];
		
		for(int i = 0 ; i < N ; i++) {
			cards[i] = sc.nextInt();
		}
		
		int answer = 0; 
		for(int a = 0 ; a < N-2 ; a++) {
			for(int b= a+1 ; b < N-1 ; b++) {
				for(int c = b+1 ; c < N ; c++) {
					int tmp = cards[a]+cards[b]+cards[c];
					if(tmp <= M) {
						if(tmp>answer) {
							answer = tmp;
						}
					}
				}
			}
		}
		
		System.out.println(answer);
		
	}

}
