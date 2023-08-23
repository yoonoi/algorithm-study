package silver;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Kh_24444 {
	public static boolean[] visited;
	public static int[] result;

	public static int N, M, R, count;
	public static ArrayList<ArrayList<Integer>> graph;
	public static Queue<Integer> Q;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		N = sc.nextInt();
		M = sc.nextInt();
		R = sc.nextInt();
		
		graph = new ArrayList<>();
		for(int i = 0 ; i <= N ; i++) {
			graph.add(new ArrayList<>());
		}
		
		for(int i = 0 ; i < M ; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			graph.get(u).add(v);
			graph.get(v).add(u);
		}
		
		for(ArrayList<Integer> L : graph) {
			L.sort(Comparator.naturalOrder());
		}
		
		visited = new boolean[N+1];
		result = new int[N+1];
		count = 0;
		Q = new LinkedList<>();
		
		bfs(R);
		
		for(int i = 1; i <= N ; i++) {
			sb.append(result[i]).append('\n');
		}
		
		System.out.println(sb);
	}

	public static void bfs(int r) {
		visited[r] = true;
		Q.add(r);
		
		while(!Q.isEmpty()) {
			int start = Q.poll();
			count++;
			result[start]=count;
			for(int i : graph.get(start)) {
				if(!visited[i]) {
					visited[i] = true;
					Q.add(i);
				}
			}
			
		}

	}
}
