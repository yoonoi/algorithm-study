package silver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Kh_2667 {
	static class Location{
		int r;
		int c;
		public Location(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[][] map = new int[N][N];
		boolean[][] visited = new boolean[N][N];
		Queue<Location> Q = new LinkedList<>();
		
		for(int i = 0 ; i < N ; i++) {
			String str = sc.next();
			for(int j = 0 ; j < N ; j++) {
				map[i][j] = str.charAt(j)-'0';
			}
		}
		
		
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
 		
		int vill = 0;
		ArrayList<Integer> housesPerVill = new ArrayList<>();
		
		for(int r = 0 ; r < N ; r++) {
			for(int c = 0 ; c < N ; c++) {
				int house = 0;
				if(!visited[r][c] && map[r][c] == 1) {
					Q.add(new Location(r, c));
					visited[r][c] = true;
					house++;
					
					
					while(!Q.isEmpty()) {
						Location tmp = Q.poll();
						
						for(int i = 0 ; i < 4 ; i++) {
							int nr = tmp.r + dr[i];
							int nc = tmp.c + dc[i];
							
							if(nr < 0 || nc < 0 || nr >= N || nc >= N) {
								continue;
							}
							
							if(!visited[nr][nc] && map[nr][nc] == 1) {
								Q.add(new Location(nr, nc));
								visited[nr][nc] = true;
								house++;
							}
						}
					}
					housesPerVill.add(house);
					vill++;
				}
			}
		}
		
		housesPerVill.sort(Comparator.naturalOrder());
		
		System.out.println(vill);
		for(int h : housesPerVill) {
			System.out.println(h);
		}
	}
	

}
