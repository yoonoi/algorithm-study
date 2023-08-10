package BOJ;

import java.util.Scanner;

public class Mw_1436 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 변수 N을 입력 받자.
		int N = sc.nextInt();
		
		// 종말의 수를 저장할 배열 apocalypse를 선언하자.
		int[] apocalypse = new int[10000];
		int index = 0;
		
		// 시간 제한을 고려하여, 1억까지 연산하자.
		for(int idx = 666; idx < 100000000; idx++) {
			if(index == 10000) {
				break;
			}
			// int 타입을 String 타입으로 변환하고 싶을 때, 공백을 더해주자. 
			String num = idx + "";
			char[] arr = num.toCharArray();
			for(int jdx = 0; jdx < arr.length-2; jdx++) {
				if(arr[jdx] == '6' && arr[jdx+1] == '6' && arr[jdx+2] == '6') {
					apocalypse[index] = idx;
					index++;
					break;
				}
			}
		}
		System.out.println(apocalypse[N-1]);
	}
}
