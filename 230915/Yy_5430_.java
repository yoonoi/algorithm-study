package friday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Yy_5430 {
	
	static Deque<String> q;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=0; tc<T; tc++) {
			String method = br.readLine(); 
			int n = Integer.parseInt(br.readLine());
			
			q = new ArrayDeque<>();
			
			// 이렇게 작성하면 [], 로 구분할 수 있음 
			StringTokenizer st = new StringTokenizer(br.readLine(), "[],");
			
			while(st.hasMoreTokens()) 
				q.offer(st.nextToken());
			
			ac(method);
		}
		
	}
	
	static void ac(String method) {
		boolean reverse = false;
		
		for(int i=0; i<method.length(); i++) {
			char c = method.charAt(i);
			
			if(c == 'R') {
				reverse = !reverse; // 이거를 그냥 true로하면 R을 짝수번했을 때 문제가 생김
				continue;
			}
			
			// 여기부턴 D 함수
			
			if(q.isEmpty()) {
				System.out.println("error");
				return;
			}
			
			if(!reverse){
				q.poll();
			} else {
				q.pollLast();
			}
		}
		
		StringBuilder sb = new StringBuilder("[");
		while(!q.isEmpty()) {
			if(!reverse) {
				sb.append(q.poll());
			} else {
				sb.append(q.pollLast());
			}
			
			if(!q.isEmpty())
				sb.append(",");
		}
		
		sb.append("]");
		
		System.out.println(sb);
	}
	
}