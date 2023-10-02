package bonus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Yy_2644 {
	
	static int n, m;
	static List<List<Integer>> list; // 연결리스트
	static int[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		list = new ArrayList<>();
		for(int i=0; i<=n; i++)
			list.add(new ArrayList<>());
		
		visited = new int[n+1];
		Arrays.fill(visited, -1);
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		m = Integer.parseInt(br.readLine());
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list.get(a).add(b);
			list.get(b).add(a);
		}
		
//		System.out.println(list);
		
		bfs(start, end);
		
	}

	static void bfs(int start, int end) {
		Queue<Integer> q = new LinkedList<>();
		
		q.offer(start);
		visited[start] = 0;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			for(int next : list.get(now)) {
				
				if(visited[next] != -1) continue;
				
				visited[next] = visited[now] + 1;
				q.offer(next);
			}
		}
		
//		System.out.println(Arrays.toString(visited));
		System.out.println(visited[end]);
	}
}
