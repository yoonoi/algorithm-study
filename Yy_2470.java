package twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Yy_2470 {
	
	static int n, ans1, ans2, sum;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
				
		Arrays.sort(arr);
		
		sum = Integer.MAX_VALUE;
		twoPointer(0, n-1);
		
		System.out.println(ans1 + " " + ans2);
	}
	
	static void twoPointer(int start, int end) {
		
		// start <= end 로 쓰면 틀림
		// 같을때는 한 숫자만 보니까 당연함..
		while(start < end && end < n) {
			int tmpSum = Math.abs(arr[start] + arr[end]);
			
			if(tmpSum < sum) {
				sum = tmpSum;
				ans1 = arr[start];
				ans2 = arr[end];
				
				if(sum == 0) break;
			}
			
			if(arr[start] + arr[end] >= 0)
				end--;
			else start++;
		}
		
	}

}
