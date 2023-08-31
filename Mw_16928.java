package BOJ;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Mw_16928 {
	static int N, M;
	static int[] board;
	static int[] visited;
	
	static Queue<Integer> q;
	
	static void play(int num) {
		q = new LinkedList<>();
		q.offer(num);
		visited[num] = 0;
		
		while(!q.isEmpty()) {
			int pop = q.poll();
			
			for(int idx = 1; idx <= 6; idx++) {
				int nextNum = pop + idx;
				
				if(nextNum > 100) continue;
				
				if(board[nextNum] != 0) {
					nextNum = board[nextNum];
				}
				
				if(visited[nextNum] != -1) continue;
				
				q.offer(nextNum);
				visited[nextNum] = visited[pop] + 1;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		board = new int[101];
		visited = new int[101];
		
		for(int idx = 0; idx < 101; idx++) {
			visited[idx] = -1;
		}
		
		for(int idx = 0; idx < N+M; idx++) {
			board[sc.nextInt()] = sc.nextInt();
		}
		
		play(1);
		
		System.out.println(visited[100]);
	}
}
