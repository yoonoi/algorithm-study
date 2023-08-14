package BOJ;

import java.util.Scanner;

public class Mw_25501 {
	// recursion 함수 호출 횟수를 저장할 변수 cnt를 선언한다.
	static int cnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 테스트케이스의 수를 입력 받는다.
		int T = sc.nextInt();
		
		for(int tc = 0; tc < T; tc++) {
			String S = sc.next();
			cnt = 0;
			System.out.println(isPalindrome(S) + " " + cnt);
		}
		
	}
	// 주어진 팰린드롬 판별 함수를 해석해보자.
	// 매개 변수 팰린드롬을 판별할 String 타입의 문자열 s, 왼쪽 인덱스를 나타내는 l, 오른쪽 인덱스를 나타내는 r로 구성되어 있다. 
	public static int recursion(String s, int l, int r) {
		cnt++;
		// 만약 l이 r과 같거나 크다면, 1(참)을 반환한다.
		if(l >= r) return 1;
		// 아니라면, 각 인덱스에 해당하는 문자를 비교해 두 값이 다르다면 0(거짓)을 반환하고,
		else if(s.charAt(l) != s.charAt(r)) return 0;
		// 아니면 recursion 함수를 다시 호출한다. 이 때, 인덱스 l은 우측으로, 인덱스 r은 좌측으로 이동한다.
		else return recursion(s, l+1, r-1);
	}
	// 팰린드롬 판별 함수 isPalindrome의 매개 변수는 String 타입의 문자열 s이며,
	public static int isPalindrome(String s) {
		// 이를 사용하면, recursion 함수를 호출한다.
		return recursion(s, 0, s.length()-1);
	}
}
