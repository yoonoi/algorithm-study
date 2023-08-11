package recur;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Yy_25501 {
	
	static StringBuilder sb = new StringBuilder();
	static int cnt;
	
	static int recur(String str, int start, int end) {
		cnt++; // 재귀함수 호출 횟수
		
		if(start >= end) {
			return 1;
		} else if(str.charAt(start) != str.charAt(end)) {
			return 0;
		} else {
			return recur(str, start+1, end-1);
		}
	}
	
	static int isPalindrome(String str) {
		return recur(str, 0, str.length() - 1);
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int i=0; i<t; i++) {
			String input = br.readLine();
			cnt = 0;
			
			sb.append(isPalindrome(input)).append(" ").append(cnt).append("\n");
		}
		
		System.out.println(sb);
	}

}
