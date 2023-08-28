package BOJ;

import java.util.Scanner;
import java.util.Stack;

public class Mw_2606 {
	static int N, E; // 노드와 간선(여기서는 컴퓨터 번호와 네트워크)
	static int[][] map; // 연결 정보를 저장할 2차원 배열 map
	static boolean[] visited; // 방문 정보를 저장할 visited 배열
	static int cnt; // 감염된 컴퓨터의 수를 저장할 변수 cnt
	
	static void search(int num) {
		cnt = 0;
		
		Stack<Integer> s = new Stack<>();
		s.push(num); 
		
		while(!s.empty()) { // 스택이 빌 때까지 반복한다.
			int cur = s.pop(); // 현재 번호를 pop 하자.
			
			if(visited[cur]) continue; // 이미 방문했던 번호라면, continue를 통해 while문의 처음으로 돌아간다.
			
			visited[cur] = true; // 아니라면 방문 처리 해주고,
			cnt++; // cnt를 증가시킨다.
			
			for(int nextNum = 1; nextNum <= N; nextNum++) {
				if(!visited[nextNum] && map[cur][nextNum] != 0) {
					s.push(nextNum);
				}
			}
		}
		System.out.println(cnt - 1); // 1번 컴퓨터를 제외해야하기 때문에 1을 빼준 값을 출력하자.
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		E = sc.nextInt();
		
		map = new int[N+1][N+1];
		visited = new boolean[N+1];
		
		for(int idx = 0; idx < E; idx++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			
			map[u][v] = map[v][u] = 1;
		}
		
		search(1); // 1번 컴퓨터를 기준으로 하기 때문에 매개변수에 1을 입력한다.
	}
}
