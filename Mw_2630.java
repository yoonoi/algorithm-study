package divideAndConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Yy_2630 {
	
	static StringTokenizer st;
	static int n, white, blue;
	static int[][] map;
	
	static void divide(int row, int col, int length) {
//		System.out.println("divide 함수 실행!");
//		System.out.println("row : " + row + " col : " + col + " 길이 : " + length + " 에서 시작");
		
		// 종료 조건
		if(checkColor(row, col, length)) {
//			System.out.println("색이 같아서 정지합니다.");
//			System.out.println("row : " + row + " col : " + col + " 길이 : " + length);
				
			if(map[row][col] == 1) {
				blue++;
//				System.out.println("파란색이 " + blue + " 만큼 증가");
			}
			else {
				white++;
//				System.out.println("흰색이 " + white + " 만큼 증가");
			}
//			System.out.println();
			
			return;
		}
		
//		System.out.println("색이 달라서 반복합니다.");
//		System.out.println();
		
		// 반복절
		length /= 2;
		divide(row, col, length); // 왼쪽 상단네모
		divide(row + length, col, length); // 왼쪽 하단네모
		divide(row, col + length, length); // 오른쪽 상단네모
		divide(row + length, col + length, length); // 오른쪽 하단네모
	}
	
	// 해당 정사각형 범위에서 색이 다 동일한지 체크하는 메서드
	static boolean checkColor(int row, int col, int length) {
		int startColor = map[row][col]; // 시작 색 확인
		
		for(int i=row; i<row+length; i++) {
			for(int j=col; j<col+length; j++) {
				// 시작색이 다르면 false 반환
				if(map[i][j] != startColor) {
					return false;
				}
			}
		}
		
		// 정사각형 색이 다 동일했으면 true 반환
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		white = 0;
		blue = 0;
		map = new int[n][n];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		divide(0, 0, n);
		System.out.println(white);
		System.out.println(blue);
	}

}
