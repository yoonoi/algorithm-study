import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Kh_16928 {
	static class Point{
		int l;
		int d;
		
		public Point(int l, int d){
			this.l = l;
			this.d = d;
		}
	}
	
	static int N, M;
	static ArrayList<ArrayList<Integer>> Map;
	static Queue<Point> Q;
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Map = new ArrayList<>();
		
		for(int i = 0 ;  i <= 100 ; i++) {
			Map.add(new ArrayList<>());			
		}		
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		for(int i = 0 ; i < N+M ; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			
			Map.get(from).add(to);
		}
		Q = new LinkedList<>();
		visited = new boolean[101];
		
		
		Q.add(new Point(1, 0));
		visited[1] = true;
		
		bfs();
		
		sc.close();
				
	}
	
	
	public static void bfs() {
		while(!Q.isEmpty()) {
			Point tmp = Q.poll();
			
			for(int i = 1 ; i <= 6 ; i++) {
				int next = tmp.l + i;
				
				if(next == 100) {
					System.out.println(tmp.d +1);
					return;
				}
				
				if(visited[next]) {
					continue;
				}
				
				if(Map.get(next).size()==0) {
					Q.add(new Point(next, tmp.d + 1));
					visited[next] = true;
				}else {
					Q.add(new Point(Map.get(next).get(0), tmp.d + 1));
					visited[next] = true;
				
				}
				
			}
		}
	}
}
