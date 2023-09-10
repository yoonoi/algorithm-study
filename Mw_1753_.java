package BOJ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Mw_1753_ {
	
	static int v, e, start;
	static final int INF = Integer.MAX_VALUE;
	static int[] dist;
	static ArrayList<Node>[] list; // 연결리스트
	
	static class Node implements Comparable<Node> {
		
		int index; // 정점 번호
		int cost;  // 가중치
		
		public Node(int index, int cost) {
			this.index = index;
			this.cost = cost;
		}

		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}
	
	public static void dijkstra(int start) { 
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			int nowIdx = now.index;
			int nowCost = now.cost;
			for(Node next : list[nowIdx]) {
				int nextIdx = next.index;
				int nextCost = next.cost;
				
				if(dist[nextIdx] > nowCost + nextCost) {
					dist[nextIdx] = nowCost + nextCost;
					pq.offer(new Node(nextIdx, dist[nextIdx]));
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		v = sc.nextInt();
		e = sc.nextInt();
		start = sc.nextInt();
		
		dist = new int[v+1];
		list = new ArrayList[v+1];
		for(int i=1; i<=v; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0; i<e; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			int w = sc.nextInt(); // 가중치
			
			list[u].add(new Node(v, w)); // 단방향 연결
		}
		
		Arrays.fill(dist, INF);
		dist[start] = 0;
		
		dijkstra(start);
		
		for(int i=1; i<=v; i++) {
			System.out.println(dist[i] == INF ? "INF" : dist[i]);
		}
		
		
	}

}