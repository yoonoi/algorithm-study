package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

// 바이러스
public class Yy_2606 {
	
	static StringTokenizer st;
	static int n, m; // 컴퓨터의 수, 간선의 수
	static Map<Integer, List<Integer>> map; // 연결리스트
	static int[] visited;
	static Queue<Integer> q = new LinkedList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		visited = new int[n+1];
		map = new HashMap<>();
		for(int i=0; i<=n; i++) 
			map.put(i, new ArrayList<>());
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			map.get(u).add(v);
			map.get(v).add(u);
		}
		
		Arrays.fill(visited, -1);
		
		// 1번 컴퓨터가 웜 바이러스에 걸렸다고 했으니 시작점은 1번 컴퓨터
		q.offer(1);
		visited[1] = 0;
		
		while(!q.isEmpty()) {
			int pop = q.poll();
			
			List<Integer> tmpList = map.get(pop);
			for(int i=0; i<tmpList.size(); i++) {
				int nextNode = tmpList.get(i);
				
				// 이미방문했는지
				if(visited[nextNode] != -1) continue;
				
				q.offer(nextNode);
				visited[nextNode] = visited[pop] + 1;
			}
		}
		
		int answ = 0;
		for(int i=2; i<=n; i++) {
			if(visited[i] != -1) {
				answ+=1;
			}
		}
		
		System.out.println(answ);
	}
}
