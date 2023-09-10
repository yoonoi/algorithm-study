package BOJ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Mw_1504_ {
	
	static class Node implements Comparable<Node> {
		int idx;
		int cost;
		
		public Node(int idx, int cost) {
			this.idx = idx;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.cost - o.cost;
		}
	}
	
	static int n, e, a, b, c; 
	static int[] dist;
	static List<Node>[] list;
	static final int INF = Integer.MAX_VALUE;
	
	static int dijkstra(int start, int end) {
		Arrays.fill(dist, INF);
		PriorityQueue<Node> pq = new PriorityQueue<>();
		
		pq.offer(new Node(start, 0));
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			
			for(Node next : list[now.idx]) {
				if(dist[next.idx] > now.cost + next.cost) {
					dist[next.idx] = now.cost + next.cost;
					pq.offer(new Node(next.idx, dist[next.idx]));
				}
			}
		}
		
//		System.out.println(start + " " + end + " 일 때 ");
//		System.out.println(Arrays.toString(dist));
//		System.out.println();
		
		return dist[end];
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		e = sc.nextInt();
		dist = new int[n+1];
//		Arrays.fill(dist, INF); 이걸 여기쓰면 안되고 메서드돌때마다 초기화
		
		list = new ArrayList[n+1];
		for(int i=1; i<=n; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0; i<e; i++) {
			a = sc.nextInt();
			b = sc.nextInt();
			c = sc.nextInt();
			
			list[a].add(new Node(b, c));
			list[b].add(new Node(a, c));
		}
		
		int v1 = sc.nextInt();
		int v2 = sc.nextInt();
		
		int tmp1 = dijkstra(1, v1) + dijkstra(v2, n);
		int tmp2 = dijkstra(1, v2) + dijkstra(v1, n);
		int tmp3 = dijkstra(v1, v2);
		
		int min = Math.min(tmp1, tmp2);
		System.out.println(min == INF || min < 0 ? -1 : min + tmp3);
	}

}