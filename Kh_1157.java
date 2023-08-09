package Bronze;

import java.util.Scanner;

public class Kh_1157 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String word = sc.next();

		int[] alphabet = new int[word.length()];

		for (int i = 0; i < word.length(); i++) {
			int toInt = (int) word.charAt(i);
			
			if(toInt>=97) {
				toInt -= 32;
			}
			
			alphabet[i] = toInt;
		}
		
		// 알파벳 대문자 ascii 65~90
		
		int[] frequency = new int[26];
		// index : -65
		
		for(int i = 0 ; i < alphabet.length ; i++) {
			frequency[alphabet[i]-65]++;
		}
		
		int max = 0;
		int frequent = 0;
		for(int i = 0 ; i < frequency.length ; i++) {
			if(frequency[i]>max) {
				max = frequency[i];
				frequent = i+65;
			}
		}
		
		int dup = 0;
		for(int i = 0 ; i < frequency.length ; i++) {
			if(frequency[i]==max) {
				dup++;
			}
			if(dup>1) {
				frequent = 0;
			}
		}
		
		if(frequent == 0) {
			System.out.println("?");
		}else {
			System.out.println((char) frequent);
		}
		
		
		
		
		
	}
}
