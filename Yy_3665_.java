package topologicalSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Yy_3665_ {
	
	static StringBuilder sb;
	
	static int n;
	static int[] ranks;
	static List<List<Integer>> list; // 기존 연결리스트
	static int[] degree; // 전입차수
	static Queue<Integer> q;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=0; tc<T; tc++) {
			n = Integer.parseInt(br.readLine());
			
			ranks = new int[n+1];
			degree = new int[n+1];
			
			list = new ArrayList<>();
			for(int i=0; i<=n; i++)
				list.add(new ArrayList<>());
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=1; i<=n; i++) 
				ranks[i] = Integer.parseInt(st.nextToken());
			
//			System.out.println("등수 : " + Arrays.toString(ranks));
//			System.out.println("진입차수 : " + Arrays.toString(degree));
			
			for(int i=1; i<=n; i++) {
				int from = ranks[i]; 
				for(int j=i+1; j<=n; j++) {
					list.get(from).add(ranks[j]); // 행 : 시작점, 열 : 도착점
					degree[ranks[j]]++;
					
					// 순위가 앞서있는 사람들이 뒤의 사람들의 정보를 가진다.
					// 그래야 나중에 뒤의 순위로 순서이동이 가능
				}
			}
			
//			System.out.println(list);
			
			int m = Integer.parseInt(br.readLine());
			for(int i=0; i<m; i++) {
				st = new StringTokenizer(br.readLine());
				
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				if(list.get(a).contains(b)) {
					list.get(a).remove((Integer)b); // (Integer)를 쓰지않으면 remove(int index)로 인식
					list.get(b).add(a);
					degree[a]++;
					degree[b]--;
				} else {
					list.get(b).remove((Integer)a);
					list.get(a).add(b);
					degree[a]--;
					degree[b]++;
				}
			}
			
			sb = new StringBuilder();
			q = new LinkedList<>();
			
			int cnt = 0;
			for(int i=1; i<=n; i++) {
				if(degree[i] == 0) {
					cnt++;
					q.offer(i);
				}
			}
			
			if(cnt > 1) {
				System.out.println("?");
				continue;
			}
			
			int result = 0;
			boolean end = false;
			for(int i=1; i<=n; i++) {
				if(q.isEmpty()) {
					System.out.println("IMPOSSIBLE");
					end = true;
					break;
				}
				
				int from = q.poll();
				result++;
				sb.append(from).append(" ");
				for(int to : list.get(from)) {
					degree[to]--;
					
					if(degree[to] == 0)
						q.offer(to);
				}
			}
			
			if(end) continue;
			
			System.out.println(sb);
		}
		
		
	}

}
