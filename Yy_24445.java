package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Yy_24445 {
	
	static int n, m, start;
	static int order = 1;
	static int[] visited;
	static List<List<Integer>> list;
	static Queue<Integer> q = new LinkedList<Integer>();
	
	static void bfs(int start) {
		
		q.offer(start);
		visited[start] = order++;
		
		while(!q.isEmpty()) {
			int pop = q.poll();
			
			for(int nextNode : list.get(pop)) {
				if(visited[nextNode] == 0) {
					q.offer(nextNode);
					visited[nextNode] = order++;
				}
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(st.nextToken());
		
		visited = new int[n+1];
		list = new ArrayList<>();
		for(int i=0; i<=n; i++) {
			list.add(new ArrayList<>());
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			list.get(u).add(v);
			list.get(v).add(u);
		}
		
		for(int i=1; i<=n; i++) {
			Collections.sort(list.get(i), Collections.reverseOrder());
		}
		
		bfs(start);
		
		for(int i=1; i<=n; i++) {
			System.out.println(visited[i]);
		}
		
	}

}
