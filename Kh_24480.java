import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Kh_24480 {
	public static int N, M, R, count;
	public static boolean[] visited;
	public static int[] result;
	public static ArrayList<ArrayList<Integer>> graph;
	
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
			int from = sc.nextInt();
			int to = sc.nextInt();
			
			graph.get(from).add(to);
			graph.get(to).add(from);
			
		}
		for(int i = 0 ; i <= N ; i++) {
			graph.get(i).sort(Comparator.reverseOrder());
		}
		
		visited = new boolean[N+1];
		result = new int[N+1];
		count = 0;	
		
		dfs(R);
		
		for(int i = 1; i <= N ; i++) {
			sb.append(result[i]).append('\n');
		}
		System.out.println(sb);
		
	}
	
	public static void dfs(int r) {
		visited[r] = true;
		count++;
		result[r] = count;
		for(int i = 0 ; i < graph.get(r).size() ; i++) {
			int n = graph.get(r).get(i);
			
			if(!visited[n]) {
				dfs(n);
			}
		}
		
		
	}

}
