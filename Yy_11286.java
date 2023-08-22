package priorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Yy_11286 {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int n, x;
	
	static PriorityQueue<Abs> pq = new PriorityQueue<>();
	
	static class Abs implements Comparable<Abs> {
		
		int key; // 절댓값 키
		int value; // 인풋값
		
		public Abs(int key, int value) {
			this.key = key;
			this.value = value;
		}

		// key에 따라 오름차순으로 정렬
		// 만약 key가 같다면 value에 따라 오름차순 정렬
		@Override
		public int compareTo(Abs o) {
			if(o.key == this.key) {
				return this.value - o.value;
			}
			
			return - o.key + this.key;
		}
		
		@Override
		public String toString() {
			return String.valueOf(value);
		}
	}
	
	static void method(int x) {
		
		if(x != 0) {
			Abs abs = new Abs(Math.abs(x), x);
			pq.offer(abs);	
		} else if(pq.isEmpty()) {
			sb.append(0).append("\n");
		} else {
			Abs abs = pq.poll();
			sb.append(abs).append("\n");
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		
		n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			x = Integer.parseInt(br.readLine());
			
			method(x);
		}
		
		System.out.println(sb);
	}
}
