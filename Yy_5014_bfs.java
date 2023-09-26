package bonus;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Yy_5014_bfs {
	
	static int F, S, G, U, D;
	static int[] visited;
	static final String IMPOSSIBLE = "use the stairs";
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		F = sc.nextInt(); // 건물 높이
		S = sc.nextInt(); // 강호가 지금 있는 곳
		G = sc.nextInt(); // 스타트링크 있는 곳(가야하는 곳)
		U = sc.nextInt(); // 위로 가는 버튼
		D = sc.nextInt(); // 아래로 가는 버튼
		
		visited = new int[F+1];
		bfs(S);
	}
	
	static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		int[] delta = {-D, U};
		
		q.offer(start);
		visited[start] = 1;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			for(int i=0; i<2; i++) {
				int next = now + delta[i];
				
				if(next > F || next <= 0) continue;
				
				if(visited[next] != 0) continue;
				
				q.offer(next);
				visited[next] = visited[now] + 1;
			}
		}
		
		System.out.println(visited[G] == 0 ? IMPOSSIBLE : visited[G] - 1);
	}

}
