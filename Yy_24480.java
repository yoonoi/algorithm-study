package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Yy_24480 {
	
	static int n, m, start;
	static int[] visited;
	static int order = 1;
	static List<List<Integer>> list;
	
	static void dfs(int start) {
		
		visited[start] = order++;
		
		for(int i=0; i<list.get(start).size(); i++) {
			int nextNode = list.get(start).get(i);
			if(visited[nextNode] == 0)	dfs(nextNode);
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
		
		dfs(start);
		
		for(int i=1; i<=n; i++) {
			System.out.println(visited[i]);
		}
	}
}
