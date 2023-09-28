package bonus;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Yy_9205_ {
	
	static int n;
	static StringBuilder sb = new StringBuilder();
	static List<Point> points; // 집, 편의점, 페스티벌 좌표 저장하는 리스트
	static List<List<Integer>> graph; 
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		for(int tc=0; tc<t; tc++) {
			n = Integer.parseInt(br.readLine());
			points = new ArrayList<>();
			
			for(int i=0; i<n+2; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				points.add(new Point(x, y));
			}

			graph = new ArrayList<>();
			for(int i=0; i<n+2; i++)
				graph.add(new ArrayList<>());
			
			// list 좌표들 중 두 좌표끼리 거리가 1000m를 만족하는 정점 2개를 찾아서 양방향으로 이어줌
			for(int i=0; i<n+2; i++) {
				for(int j=i+1; j<n+2; j++) {
					if(getDistance(points.get(i), points.get(j)) <= 1000) {
						graph.get(i).add(j);
						graph.get(j).add(i);
					}
				}
			}
			
			sb.append(bfs(0) ? "happy" : "sad").append("\n");
		}
		
		System.out.println(sb);
		
	}
	
	static int getDistance(Point p1, Point p2) {
		return Math.abs(p1.x - p2.x) + Math.abs(p1.y - p2.y);
	}	
	
	static boolean bfs(int startIdx) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[n+2];
		
		q.offer(startIdx);
		visited[startIdx] = true;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			if(now == n+1) return true;
			
			for(int next : graph.get(now)) {
				if(!visited[next]) {
					visited[next] = true;
					q.offer(next);
				}
			}
		}
		
		return false;
	}

}
