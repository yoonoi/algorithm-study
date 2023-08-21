package priorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Yy_11279 {
	
	static int n, x;
	static int[] arr;
	static PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		for(int i=0; i<n; i++) {
			x = Integer.parseInt(br.readLine());
			
			if(x == 0) {
				if(!pq.isEmpty())
					sb.append(pq.poll()).append("\n");
				else 
					sb.append(0).append("\n");
			} else {
				pq.offer(x);
			}
		}
		
		System.out.println(sb);
	}

}
