package topologicalSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
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
 * 		#3. 스택이 빌 때까지 POP한다.(출력)
 * 
 *  2. 큐를 이용한 구현
 *  	#1. 진입차수가 0인 모든 노드를 큐에 넣는다.
 *  	#2. 큐가 빌 때 까지 POP한다.(출력)
 *  		1) POP한 노드와 인접하다면 해당 노드의 진입차수를 -1 해준다.
 *  		2) 만약 -1한 후 진입차수가 0이 되면 해당 노드도 큐에 넣는다.
 *  
 */
public class Yy_2252_queue {
	
	static int n, m; // 학생 수, 키를 비교한 횟수
	
	static int[] degree; // 진입차수 배열 - 특정 노드로 들어오는 간선의 개수
	// 위상정렬에서는 진입에 포커스를 맞춤!
	// 내 정점에 진입차수가 있다면? -> 선행조건이 있다는 뜻!
	
//	static int[][] list; // 인접 리스트 -> 이차 행렬로 하면 메모리 초과
	static List<List<Integer>> list;
	
	static Queue<Integer> q = new LinkedList<>(); // visited 필요 없음
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
//		list = new int[n+1][n+1];
		list = new ArrayList<>();
		for(int i=0; i<=n; i++)
			list.add(new ArrayList<>());
		
		degree = new int[n+1];
		
		m = Integer.parseInt(st.nextToken());
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			// 인접 정보 받기
//			list[A][B] = 1; // 행: 시작점 & 열: 도착점
			list.get(A).add(B); 
			
			// 진입차수 정보 받기 -> 도착점으로 진입하니까 도착점에 누적해주기
			// B점에 진입하는 애가 몇갠지 작성
			degree[B]++; 
		}
		
		for(int i=1; i<=n; i++) {
			// 1. 진입차수가 0인 모든 노드를 큐에 넣고 시작
			if(degree[i] == 0) 
				q.offer(i);
		}
		
		// 2. 큐가 빌 때 까지 poll
		topological();
		
	}
	
	static void topological() {
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			System.out.print(now + " ");
			
//			for(int i=1; i<=n; i++) {
//				// 인접하다면
//				if(list[now][i] == 1) {
//					// 진입차수 - 1을 해준다.
//					degree[i]--;
//					
//					// 진입차수가 0이 됐으면 마찬가지로 큐에 넣어준다
//					if(degree[i] == 0)
//						q.offer(i);
//				}
//			}
			
			// 인접한 애들 조회
			for(int next : list.get(now)) {
				degree[next]--;
				
				if(degree[next] == 0) 
					q.offer(next);
			}
		}
	}

}
