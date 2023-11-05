package BOJ;

import java.util.Scanner;

public class Mw_12904 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String S = sc.next();
		String T = sc.next();
		int answer = 9;
		
		while(T != "") {
			if(T.equals(S)) {
				answer = 1;
				break;
			} else if(!T.equals(S) && T.length() == 1) {
				answer = 0;
				break;
			}
			char[] arr = T.toCharArray();
			if(arr[arr.length-1] == 'A') {
				T = "";
				for(int idx = 0; idx < arr.length-1; idx++) {
					T += arr[idx];
				}
			} else if(arr[arr.length-1] == 'B') {
				T = "";
				for(int idx = arr.length-2; idx >= 0 ; idx--) {
					T += arr[idx];
				}
			}
				
		}
		System.out.println(answer);
	}
}
