package friday;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Yy_15686_ {
	
	 static int n, m, ans;
	 static int[][] board;
	 static boolean[] open;
	 
	 static final int INF = Integer.MAX_VALUE;
	 static final int CHICKEN = 2;
	 static final int HOUSE = 1;
	 
	 static List<Point> house = new ArrayList<>();		static int houseCnt = 0;
	 static List<Point> chicken = new ArrayList<>();	static int chickenCnt = 0;

	 public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		board = new int[n][n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				
				if(board[i][j] == HOUSE) {
					house.add(new Point(i, j));
					houseCnt++;
					continue;
				}
				
				if(board[i][j] == CHICKEN) {
					chicken.add(new Point(i, j));
					chickenCnt++;
				}
			}
		}
		
		ans = INF;
		open = new boolean[chickenCnt]; // 오픈한 치킷집 수
		
		dfs(0, 0);
		System.out.println(ans);
	 }
	 
	 static void dfs(int start, int depth) {
		 // 인덱스값이 m이 된다면,
		 // 집 리스트에 있는 값들을 순회하면서 
		 // 해당 도시의 치킨거리 및 전체 도시의 치킨거리를 구한다.
		 if(depth == m) {
			 int res = 0; // 전체 도시의 임시 치킨거리
			 
			 for(int i=0; i<houseCnt; i++) {
				 int tmp = INF; // 해당 도시의 치킨거리
				 
				 // 해당 집과 open한 치킨집의 모든 거리를 비교
				 // 그 중 최소 거리를 구한다.
				 for(int j=0; j<chickenCnt; j++) {
					 
					 // 오픈한 치킨집
					 if(open[j]) {
						 int dist = Math.abs(house.get(i).x - chicken.get(j).x) +
								 Math.abs(house.get(i).y - chicken.get(j).y);
						 
						 tmp = Math.min(tmp, dist);
					 }
				 }
				 
				 res += tmp;
			 }
			 
			 ans = Math.min(ans, res);
			 return;
		 }
		 
		 // 백트래킹을 활용해 치킨집들을 하나씩 순회한다.
		 for(int i=start; i<chickenCnt; i++) {
			 open[i] = true;
			 dfs(i+1, depth+1);
			 open[i] = false;
		 }
		 
	 }

}
