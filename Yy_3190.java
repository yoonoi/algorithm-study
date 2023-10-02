package bonus;

import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Yy_3190 {
	
	static int n, k, l;
	static boolean[][] board;
	static Map<Integer, String> spins;
	static List<Point> snake; // 뱀의 위치들 넣을 리스트
	
	// direction
	// 0 : 오른쪽, 1 : 아래쪽, 2 : 왼쪽, 3 : 위쪽
	static final int LEFT = 2;
	static final int RIGHT = 0;
	static final int UP = 3;
	static final int DOWN = 1;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		board = new boolean[n][n];
		
		k = sc.nextInt();
		for(int i=0; i<k; i++) {
			int row = sc.nextInt() - 1;
			int col = sc.nextInt() - 1;
			
			board[row][col] = true; // 사과
		}
		
		snake = new ArrayList<>();
		
		spins = new HashMap<>();
		l = sc.nextInt();
		for(int i=0; i<l; i++) {
			int x = sc.nextInt(); // 게임 시작 시간으로부터 x초가 끝난 뒤에 
			String c = sc.next(); // L : 왼쪽, D : 오른쪽 으로 90도 방향을 회전한다.
			
			spins.put(x, c);
		}
		
		snake.add(new Point(0, 0)); // 맨처음 시작위치
		// 먼저 뱀은 몸을 늘려 머리를 다음칸에 위치시킬거임
		move(0, 0, 0, 1, 1); // 1초되서 이동
	}

	static void move(int row, int col, int direction, int size, int sec) {
		int nextRow = row;
		int nextCol = col;
		
		switch (direction) {
		case LEFT:
			nextCol -= 1;
			break;
		case RIGHT:
			nextCol += 1;
			break;
		case UP:
			nextRow -= 1;
			break;
		case DOWN :
			nextRow += 1;
		}
		
		// 벽에 닿으면 게임 오버
		if(isOutOfIndex(nextRow, nextCol)) {
			System.out.println(sec);
			return ;
		}
		
		// 자기 자신과 닿아도 게임 오버
		if(touchMySelf(nextRow, nextCol)) {
			System.out.println(sec);
			return;
		}
		
		// 이동 가능하니 다음칸으로 이동
		snake.add(new Point(nextRow, nextCol));
		
		// 사과가 없으면 꼬리 삭제
		if(!board[nextRow][nextCol])
			snake.remove(0);
		
		// 사과가 있으면 사이즈 증가
		else {
			board[nextRow][nextCol] = false; // 사과 먹어버림
			size++;
		}
		
		// 방향 안바꿔도 되는지 체크
		// 방향 바꿀떄가 되면 방향 바꿔준 후 spins에서 지워준다.
		if(checkSpins(sec)) {
			direction = changeDirection(spins.get(sec), direction);
			spins.remove(sec);
		}
		
		// 다음칸으로 또 이동할거니까
		move(nextRow, nextCol, direction, size, sec+1);
	}
	
	static boolean isOutOfIndex(int row, int col) {
		return row < 0 || col < 0 || row >= n || col >= n;
	}
	
	static boolean touchMySelf(int row, int col) {
		return snake.contains(new Point(row, col));
	}
	
	static boolean checkSpins(int sec) {
		for(int times : spins.keySet()) {
			if(times == sec)
				return true;
		}
		
		return false;
	}
	
	// 0 : 오른쪽, 1 : 아래쪽, 2 : 왼쪽, 3 : 위쪽
	static int changeDirection(String spin, int direction) {
		// 왼쪽으로 90도 회전이면
		if(spin.equals("L")) 
			// 위 -> 왼     3 -> 2
			// 왼 -> 아래    2 -> 1
			// 아래 -> 오    1- > 0
			// 오 -> 위    0 -> 3
			direction += 3;
		// 오른쪽으로 90도 회전이면
		else 
			// 위 -> 오  3- > 0
			// 오 -> 아  0 -> 1
			// 아 -> 왼  1 -> 2
			// 왼 -> 위  2 -> 3
			direction += 1;
		
		direction %= 4;
		
		return direction;
	}
}
