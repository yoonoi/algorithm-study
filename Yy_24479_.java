package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Yy_24479 {
	
	static int n, m, start, cnt; // 정점, 간선, 시작점
	static int[] visited; 
	static List<List<Integer>> list; // 연결리스트
	
	static void dfs(int start) {
		
		visited[start] = cnt++;
		
		for(int i=0; i<list.get(start).size(); i++) {
			int next = list.get(start).get(i);
			if(visited[next] == 0) dfs(next);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(st.nextToken());
		
		cnt = 1;
		list = new ArrayList<>();
		for(int i=0; i<=n; i++) 
			list.add(new ArrayList<>());
		
		visited = new int[n+1];
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			list.get(u).add(v);
			list.get(v).add(u);
		}
		
		for(int i=0; i<=n; i++) 
			Collections.sort(list.get(i));
		
		dfs(start);
		
		for(int i=1; i<=n; i++) {
			System.out.println(visited[i]);
		}
	}
}
