package recur;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Yy_24060 {
	
	static int n, k, cnt;
	static int[] arr, sorted;
	
	static void mergeSort(int[] arr, int start, int end) {
		if(start < end) {
			int mid = (start + end) / 2; // q는 p, r의 중간값
			mergeSort(arr, start, mid);
			mergeSort(arr, mid+1, end);
			merge(arr, start, mid, end);
		}
	}
	
	static void merge(int[] arr, int start, int mid, int end) {
		int idx = start;
		int idx2 = mid+1;
		int t = start;
		
		while(idx <= mid && idx2 <= end) {
			if(arr[idx] <= arr[idx2]) 
				sorted[t++] = arr[idx++];
			else 
				sorted[t++] = arr[idx2++];
		}
		
		while(idx <= mid) 
			sorted[t++] = arr[idx++];
		
		while(idx2 <= end) 
			sorted[t++] = arr[idx2++];
		
		for(int i=start; i<=end; i++) {
			cnt++;
			arr[i] = sorted[i];
			
			if(cnt == k) 
				System.out.println(sorted[i]); // arr에 저장되는 값
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		arr = new int[n];
		sorted = new int[n];
		
		for(int i=0; i<n; i++) 
			arr[i] = Integer.parseInt(st.nextToken());
		
		cnt = 0;
		mergeSort(arr, 0, arr.length-1);
		
		if(cnt < k) 
			System.out.println(-1);
		
	}
}
