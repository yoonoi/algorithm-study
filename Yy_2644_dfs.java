package bonus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Yy_2644_dfs {
	
	static int n, m, start, end, cnt;
	static List<List<Integer>> list; // 연결리스트
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		cnt = -1;
		
		list = new ArrayList<>();
		for(int i=0; i<=n; i++)
			list.add(new ArrayList<>());
		
		visited = new boolean[n+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		m = Integer.parseInt(br.readLine());
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list.get(a).add(b);
			list.get(b).add(a);
		}
		
		dfs(start, 0);
		System.out.println(cnt);
	}
	
	static void dfs(int start, int depth) {
		
		if(start == end) {
			cnt = depth;
			return;
		}
		
		visited[start] = true;
		
		for(int next : list.get(start)) {
			if(!visited[next])
				dfs(next, depth + 1);
		}
	}

}
