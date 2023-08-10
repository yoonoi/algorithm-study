package BOJ;

import java.util.Scanner;

public class Mw_2839 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 배달해야하는 무게를 나타내는 변수 N을 입력 받자. 
		int N = sc.nextInt();
		// 5킬로그램 짜리 설탕의 봉지 수를 나타내는 변수 cnt5를 선언하고 0으로 초기화하자.
		int cnt5 = 0;
		// 3킬로그램 짜리 설탕의 봉지 수를 나타내는 변수 cnt3를 선언하고 0으로 초기화하자.
		int cnt3 = 0;
		
		while(N >= 3) {
			if(N%5 == 0) {
				cnt5 = N/5;
				break;
			} else {
				N -=3;
				cnt3++;
			}
		}
		if(N%5 == 0) {
			System.out.println(cnt5 + cnt3);
		} else {
			System.out.println(-1);
		}
	}
}
