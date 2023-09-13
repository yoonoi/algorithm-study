package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Yy_10816_ {
	
	static int n;
	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(arr);
		
		int m = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<m; i++) {
			int key = Integer.parseInt(st.nextToken());
			
			sb.append(upperBound(key) - lowerBound(key)).append(" ");
		}
		
		System.out.println(sb);
	}
	
	static int lowerBound(int key) {
		int low = 0;
		int high = n;
		
		while(low < high) {
			int mid = (low + high) / 2;
			
			if(key <= arr[mid]) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}
		
		return low;
	}
	
	static int upperBound(int key) {
		int low = 0;
		int high = n;
		
		while(low < high) {
			int mid = (low + high) / 2;
			if(key < arr[mid]) {
				high = mid;
			} else {
				low = mid + 1;
			}
		}
		
		return low;
	}

}
