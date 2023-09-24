package twoPointer;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Yy_3273_ {
	
	static int n, x, cnt;
	static Set<Integer> set = new HashSet<>();
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		for(int i=0; i<n; i++)
			set.add(sc.nextInt());
		
		x = sc.nextInt();
		cnt = 0;
		
		checkSum(x);
	}
	
	static void checkSum(int x) {
		
		for(int start : set) {
			int end = x - start;
			
			if(set.contains(end))
				cnt++;
		}
		
		System.out.println(cnt /= 2);
	}
	
//	static void twoPointer(int x) {
//		int start = 0;
//		int end = 0;
//		int sum = 0;
//		
//		// 시작포인터가 전체 수열 인덱스보다 작을 동안
//		while(start < n) {
//			if(sum > x || end == n) 
//				sum -= arr[start++];
//			else
//				sum += arr[end++];
//			
//			
//			System.out.println("start : " + start);
//			System.out.println("end : " + end);
//			System.out.println("sum : " + sum);
//			
//			if(sum == x)
//				cnt++;
//		}
//		
//		System.out.println(cnt);
//	}

}
