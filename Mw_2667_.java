package BOJ;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Mw_2667_ {
	static int N;
	static int [][] Map;
	static int cnt;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	
	static ArrayList<Integer> result;
	
	static boolean[][] check;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		Map = new int[N][N];
		
		check = new boolean[N][N];
		
		for(int idx = 0; idx < N; idx++) {
			String input = sc.next();
			for(int jdx = 0; jdx < N; jdx++) {
				Map[idx][jdx] = input.charAt(jdx) -'0';
			}
		}
		
		cnt = 0;
		
		result = new ArrayList<>();
		
		for(int idx = 0; idx < N; idx++) {
			for(int jdx = 0; jdx < N; jdx++) {
				if(Map[idx][jdx] == 1 && !check[idx][jdx]) {
					cnt = 1;
					search(idx, jdx);
					result.add(cnt);
				}
			}
		}
		
		Collections.sort(result);
		System.out.println(result.size());
		for(int c : result) System.out.println(c);
	}
	
	public static int search(int x, int y) {
		check[x][y] = true;
		
		for(int idx = 0; idx < 4; idx++) {
			int nx = x + dr[idx];
			int ny = y + dc[idx];
			
			if(nx >= 0 && ny >= 0 && nx < N && ny < N) {
				if(Map[nx][ny] == 1 && !check[nx][ny]) {
					search(nx, ny);
					cnt++;
				}
			}
		}
		return cnt;
	}
}
