package greedy;
import java.util.Scanner;

public class Mw_11047 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 동전 종류의 개수
		int K = sc.nextInt(); // 가치의 합
		int cnt = 0;
		
		int[] coin = new int[N];
		
		for(int idx = 0; idx < N; idx++) {
			coin[idx] = sc.nextInt();
		}
		
		for(int idx = N-1; idx >= 0; idx--) {
			if(K >= coin[idx]) {
				cnt += K / coin[idx];
				K %= coin[idx];
				if(K == 0) break;
			}
		}
		System.out.println(cnt);
	}
}
