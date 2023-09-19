package topologicalSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 스택
 * 
 * 1. 진입차수가 0인 노드를 하나씩 DFS를 돈다.
 * 2. 해당 노드를 방문처리해준다.
 * 3. 인접하면서 방문하지 않은 노드에서 DFS를 수행한다.
 * 4. DFS가 리턴되기 전에 스택에 넣어준다.
 * 5. 스택이 빌 때 까지 pop하면서 출력한다.
 * 
 * 큐
 * 
 * 1. 진입차수가 0인 모든 노드를 큐에 넣어준다.
 * 2. 큐가 빌 때 까지 poll하면서 출력한다.
 * 3. poll한 노드와 인접한 노드의 진입차수를 -1 해준다.
 * 4. 해당 노드의 진입차수가 0이 되면 마찬가지로 큐에 넣어준다.
 * 
 */
public class Yy_1766 {
	
	static StringBuilder sb = new StringBuilder();
	
	static int n, m;
	static int[] degree; // 선행차수 -> 나보다 선행되는 노드의 개수 입력
	static List<List<Integer>> list = new ArrayList<>(); // 연결리스트
	static PriorityQueue<Integer> q = new PriorityQueue<>(); // 문제번호순으로 오름차순하기 위해 우선순위 큐 사용
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		degree = new int[n+1];
		for(int i=0; i<=n; i++)
			list.add(new ArrayList<>());
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			list.get(A).add(B); // 연결리스트에 연결 표시
			degree[B]++;  // B의 선행차수 증가시키기
		}
		
		// n번부터 1번 순으로 집어넣어도 우선순위큐라 1번부터 제대로 정렬
		for(int i=n; i>=1; i--) {
			if(degree[i] == 0)
				q.offer(i);
		}
		
		topological();
		
		System.out.println(sb);
	}
	
	static void topological() {
		while(!q.isEmpty()) {
			int now = q.poll();
			sb.append(now).append(" ");
			
			for(int connect : list.get(now)) {
				degree[connect]--;
				
				if(degree[connect] == 0)
					q.offer(connect);
			}
		}
	}

}
