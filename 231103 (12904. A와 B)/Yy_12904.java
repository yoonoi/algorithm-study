package friday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Yy_12904 {

    static String s, t;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        s = br.readLine();
        t = br.readLine();
        
        StringBuilder sb = new StringBuilder(t);
        reverseCheck(sb);
    }

    static void reverseCheck(StringBuilder sb) {
    	
    	while(true) {
    		// 맨 뒷글자가 'A'일 때
    		if(sb.charAt(sb.length() - 1) == 'A') {
    			sb.deleteCharAt(sb.length() - 1);
    		} 
    		// 맨 뒷글자가 'B'일 때
    		else {
    			sb.deleteCharAt(sb.length() - 1);
    			sb.reverse();
    		}
    		
    		if(sb.toString().equals(s)) {
    			System.out.println(1);
    			return;
    		}
    		
    		if(sb.length() == 0) {
    			System.out.println(0);
    			return;
    		}
    	}
    	
    }
    
}
