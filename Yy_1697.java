package graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Yy_1697 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 수빈
		int k = sc.nextInt(); // 덩생
		
		int[] times = new int[100001];
		Arrays.fill(times, -1);
		
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(n);
		times[n] = 0;
		
		int[] delta = {-1, 1};
		while(!q.isEmpty()) {
			
			int pop = q.poll();
			
			for(int i=0; i<3; i++) {
				int next = i != 2 ? pop + delta[i] : pop * 2;
				
				// 범위 넘어서면 패스
				if(next < 0 || next >= 100001) continue; 
				
				// 이미 지나왔으면 지금시간보단 빠를테니 패스
				if(times[next] != -1) continue; 
				
				q.add(next);
				times[next] = times[pop] + 1;
			}
		}
		
		System.out.println(times[k]);
	}
}
