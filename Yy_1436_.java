package bruteforce;

import java.util.Scanner;

/**
 * https://st-lab.tistory.com/103
 */

// 구글링한건 저처럼 파일명_ 언더바 붙이면 됩ㄴㅣ당~~~
public class Yy_1436_ {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		for(int i=666, cnt = 0; ; i++) {
			String str = String.valueOf(i);
			
			if(str.contains("666"))	cnt++;
			
			if(cnt == n) {
				System.out.println(str);
				break;
			}
		}
	}
}
