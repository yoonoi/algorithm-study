package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Yy_2579 {

	static int n;
	static int[] stairs, scores;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		stairs = new int[n+1];
		scores = new int[n+1];
		for(int i=1; i<=n; i++) {
			stairs[i] = Integer.parseInt(br.readLine());
			scores[i] = stairs[i];
		}
		
		System.out.println(dp(n));
	}
	
	static int dp(int k) {
		
		if(n >= 2) 
			scores[2] = stairs[1] + stairs[2];
		
		for(int i=3; i<=n; i++) 
			scores[i] = Math.max(scores[i-2] + stairs[i], scores[i-3] + stairs[i-1] + stairs[i]);
		
		return scores[k];
	}
	
	
}
