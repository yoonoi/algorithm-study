package BOJ;

import java.util.Scanner;
		
public class Mw_2231 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 자연수 N을 입력 받는다.
		int N = sc.nextInt();
		// 생성자를 저장할 변수 result를 선언하고 0으로 초기화한다.
		int result = 0;
		
		// 반복문을 통해 낮은 수부터 탐색한다.
		for(int idx = 1; idx < N; idx++) {
			String num = idx + "";
			char[] arr = num.toCharArray();
			int sum = idx;
			for(int jdx = 0; jdx < arr.length; jdx++) {
				// char 타입을 int 타입으로 변환하기 위해 0을 빼준다.(아스키 코드의 특성 활용)
				sum += arr[jdx] - '0';
			}
			if(N == sum) {
				result = idx;
				break;
			}
		}
		// 값을 출력한다.
		System.out.println(result);
	}
}
