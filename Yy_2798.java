package bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Yy_2798 {
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] cards = new int[n]; // 카드 넣을 배열
		int maxSum = 0; // 최대합(정답)
		
		st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<n; i++) 
			cards[i] = Integer.parseInt(st.nextToken());

		// 브루트포스 
		for(int i=0; i<n; i++) {
			int sum = cards[i];
			
			for(int j=i+1; j<n; j++) {
				sum += cards[j];
				
				for(int k=j+1; k<n; k++) {
					sum += cards[k];
					
					if(sum <= m && maxSum < sum) maxSum = sum;
					
					sum -= cards[k];
				}
				
				sum -= cards[j];
			}
		}
		
		System.out.println(maxSum);
	}
}
