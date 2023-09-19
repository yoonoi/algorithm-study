package topologicalSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

/*
 * 위상정렬: 선행 관계
 * 
 * 1. 스택을 이용한 구현
 * 		#1. 진입차수가 0인 모든 노드에서 DFS 탐색을 수행한다.
 * 		#2. DFS 수행
 * 			1) 해당 노드를 방문 표시
 * 			2) 인접하면서 방문하지 않은 노드가 있다면 DFS 재귀 호출
 * 			3) 함수 리턴하기 전에 스택에 현재 노드 저장
 * 		#3. 스택이 빌 때까지 POP한다.
 * 
 *  2. 큐를 이용한 구현
 *  	#1. 진입차수가 0인 모든 노드를 큐에 넣는다.
 *  	#2. 큐가 빌 때 까지 POP한다.(출력)
 *  		1) POP한 노드와 인접하다면 해당 노드의 진입차수를 -1 해준다.
 *  		2) 만약 -1한 후 진입차수가 0이 되면 해당 노드도 큐에 넣는다.
 *  
 */
public class Yy_2252_stack {
	
	static int n, m; // 학생 수, 키를 비교한 횟수
	
	static int[] degree; // 진입차수 배열 - 특정 노드로 들어오는 간선의 개수
	// 위상정렬에서는 진입에 포커스를 맞춤!
	// 내 정점에 진입차수가 있다면? -> 선행조건이 있다는 뜻!
	
	static List<List<Integer>> list;  // int[][] 는 메모리초과
	static boolean[] visited; // 방문표시
	static Stack<Integer> stack = new Stack<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		
		list = new ArrayList<>();
		for(int i=0; i<=n; i++)
			list.add(new ArrayList<>());
		
		degree = new int[n+1];
		visited = new boolean[n+1];
		
		m = Integer.parseInt(st.nextToken());
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			// 인접 정보 받기
			list.get(A).add(B);
			
			// 진입차수 정보 받기 -> 도착점으로 진입하니까 도착점에 누적해주기
			// B점에 진입하는 애가 몇갠지 작성
			degree[B]++; 
		}
		
		for(int i=1; i<=n; i++) {
			// 1. 진입차수가 0인 모든 노드에서 DFS 탐색 수행(선행차수가 없는 애부터 출발해야 하니까)
			if(degree[i] == 0) 
				topologicalDFS(i);
		}
		
		// 3. 스택이 빌 때 까지 pop
		while(!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
		System.out.println();
		
	}
	
	static void topologicalDFS(int node) {
		// 2-1. 해당 노드를 방문 표시
		visited[node] = true;
		
		// 정점 전체를 돌면서
//		for(int i=1; i<=n; i++) {
//			// 2-2. 인접하면서 방문하지 않은 노드가 있다면
//			if(list[node][i] == 1 && !visited[i]) {
//				// DFS 호출
//				topologicalDFS(i);
//			}
//		}
		
		// 2-2. 인접하면서 방문하지 않은 노드가 있다면
		for(int connect : list.get(node)) {
			if(!visited[connect])
				topologicalDFS(connect); // DFS 호출
		}
		
		// 2-3. 함수 리턴하기 전에 스택에 현재 노드를 저장
		stack.push(node);
	}

}
