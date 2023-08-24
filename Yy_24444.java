package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Yy_24444 {
	
	static int n, m, start;
	static Queue<Integer> q = new LinkedList<Integer>();
	static int[] visited;
	static List<List<Integer>> list = new ArrayList<>();
	static int cnt = 1;
	
	static void bfs(int start) {
		
		q.offer(start);
		visited[start] = cnt++;
		
		while(!q.isEmpty()) {
			int pop = q.poll();
			
			List<Integer> tmp = list.get(pop);
			
			for(int i=0; i<tmp.size(); i++) {
				int next = tmp.get(i);
				
				if(visited[next] != 0) continue;
				
				q.offer(next);
				visited[next] = cnt++;
			}
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<=n; i++) {
			list.add(new ArrayList<>());
		}
		
		visited = new int[n+1];
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			list.get(u).add(v);
			list.get(v).add(u);
		}
		
		for(int i=0; i<=n; i++) {
			Collections.sort(list.get(i));
		}
		
		bfs(start);
		
		for(int i=1; i<=n; i++) 
			System.out.println(visited[i]);
		
	}
}
