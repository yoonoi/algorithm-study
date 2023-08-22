package priorityQueue;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Yy_1927 {
	
	static PriorityQueue<Integer> pq = new PriorityQueue<>(); // 기본 오름차순
	static Scanner sc = new Scanner(System.in);
	static StringBuilder sb = new StringBuilder();
	static int n, x;
	
	static void method(int x) {
		if(x != 0) 
			pq.offer(x);
		else if(!pq.isEmpty()) {
			sb.append(pq.poll()).append("\n");
		} else
			sb.append(0).append("\n");
	}
	
	public static void main(String[] args) {
		
		n = sc.nextInt();
		for(int i=0; i<n; i++) {
			x = sc.nextInt();
			
			method(x);
		}
		
		System.out.println(sb);
	}
}
