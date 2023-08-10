package algorithm_study.simhwa1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Yy_1157 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine().toUpperCase();
		
		int[] cnts = new int[26]; // 알파벳 개수
		
		for(int i=0; i<input.length(); i++) 
			cnts[input.charAt(i) - 65]++;
		
		int maxCnt = -1;
		int maxNum = -1;
		for(int i=0; i<26; i++) {
			if(cnts[i] >= maxCnt) {
				maxCnt = cnts[i];
				maxNum = i;
			}
		}
		
		for(int i=0; i<26; i++) {
			if(cnts[i] == maxCnt && maxNum != i) {
				maxNum = -1;
				break;
			}
		}
		
		System.out.println(maxNum == -1 ? "?" : (char)(maxNum + 65));
	}
}
