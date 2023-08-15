package silver;

import java.util.Scanner;

public class Kh_24060 {
	static int[] arr, sorted;
	static int N,K,count, ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		K = sc.nextInt();
		
		arr = new int[N];
		sorted = new int[N];
		
		for(int i = 0 ; i < N ; i++) {
			arr[i] = sc.nextInt();
		}
		count = 0;
		ans = -1;
		
		
		mergeSort(0, N-1);
		
		System.out.println(ans);
		
		
		
	}
	
	public static void mergeSort(int l, int r) {
		if(l>= r) {
			return;
		}
		
		int mid = (l+r)/2;
		
		mergeSort(l, mid);
		mergeSort(mid+1, r);
		merge(l, r, mid);
	}
	
	public static void merge(int l, int r, int m) {
		int firstL = l;
		int firstR = m+1;
		int idx = l;
		
		
		while(firstL <= m && firstR <=r) {
			if(arr[firstL] <=  arr[firstR]) {
				sorted[idx++]=arr[firstL++];
			}else {
				sorted[idx++]=arr[firstR++];
			}
		}
		
		if(firstL<=m) {
			for(int i = firstL ; i <= m ; i++) {
				sorted[idx++]=arr[i];
			}
		}else if(firstR<=r) {
			for(int i = firstR ; i <= r ; i++) {
				sorted[idx++]=arr[i];
			}
		}
		
		for(int i =l ; i <= r; i++) {
			arr[i] = sorted[i];
			count++;
			if(count==K) {
				ans=arr[i];
			}
		}
		
	}

}
