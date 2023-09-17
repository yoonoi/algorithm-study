package friday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Yy_5430_2 {
	
	static Deque<String> q;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=0; tc<T; tc++) {
			String method = br.readLine(); 
			int n = Integer.parseInt(br.readLine());
			
			q = new ArrayDeque<>();
			
			StringTokenizer st = new StringTokenizer(br.readLine(), "[],");
			while(st.hasMoreTokens()) 
				q.offer(st.nextToken());
			
			ac(method);
		}
		
	}
	
	static void ac(String method) {
		int order = 0;
		
		for(int i=0; i<method.length(); i++) {
			char c = method.charAt(i);
			
			if(c == 'R') 
				order++;
			
			if(c == 'D') {
				if(q.isEmpty()) {
					System.out.println("error");
					return;
				}
				
				if(order % 2 == 0){
					q.poll();
				} else {
					q.pollLast();
				}
			}
		}
		
		if(order % 2 == 0) {
			System.out.println(q);
		} else {
			Queue<String> reverseQ = new LinkedList<>();
			
			while(!q.isEmpty()) {
				reverseQ.offer(q.pollLast());
			}
			
			System.out.println(reverseQ);
		}
	}
	
}