package bruteforce;

import java.util.Scanner;

public class Yy_2839 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		// 1. 브루트포스(완전탐색)
		for(int i=0; ; i++) {
			// 3킬로그램 봉지 수
			int sum = 3 * i;
			
			if(sum > n) {
				System.out.println(-1);
				return;
			}
			
			for(int j=0; ; j++) {
				// 5킬로그램 봉지 수
				sum += 5 * j;
				
				if(sum == n) {
					System.out.println(i + j);
					return;
				} 
				
				if(sum > n) break;
				
				sum -= 5 * j;
			}
		}
		
		// 2. 야매
//		int cnt = 0; int tmpCnt = 0; boolean possible = false;
//		while(n > 0) {
//			cnt += n/5;
//			
//			if((n % 5) % 3 == 0) {
//				cnt += (n % 5) / 3;
//				possible = true;
//				break;
//			}
//			
//			else {
//				n -= 3;
//				cnt = ++tmpCnt;
//			}
//		}
//		
//		if(possible) 
//			System.out.println(cnt);
//		else
//			System.out.println(-1);
		
		// 3. 숏코딩
//		int cnt = 0;
//		while(n % 5 != 0) {  // 음수 나눠도 에러안남
//			n -= 3;
//			cnt++;
//		}
//		if(n < 0) 
//			System.out.println(-1);
//		else {
//			cnt += n / 5;
//			System.out.println(cnt);
//		}
		
	}
}
