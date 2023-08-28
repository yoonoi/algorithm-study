package gold;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Kh_4179 {
	static class Location {
		int row;
		int col;

		public Location(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Queue<Location> F = new LinkedList<>();
		Queue<Location> Q = new LinkedList<>();
		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		int R = sc.nextInt();
		int C = sc.nextInt();

		int[][] distJ = new int[R][C];
		int[][] distF = new int[R][C];
		char[][] escape = new char[R][C];

		for (int i = 0; i < R; i++) {
			String str = sc.next();
			for (int j = 0; j < C; j++) {
				escape[i][j] = str.charAt(j);
				if (escape[i][j] == 'J') {
					Q.add(new Location(i, j));
					distJ[i][j]++;
				} else if (escape[i][j] == 'F') {
					F.add(new Location(i, j));
					distF[i][j]++;
				}

			}
		}

		while (!F.isEmpty()) {
			Location tmpF = F.poll();
			int tmpFR = tmpF.row;
			int tmpFC = tmpF.col;

			for (int i = 0; i < 4; i++) {

				int Fnr = tmpFR + dr[i];
				int Fnc = tmpFC + dc[i];

				if (Fnr < 0 || Fnc < 0 || Fnr >= R || Fnc >= C) {

					continue;
				}

				if (distF[Fnr][Fnc] >= 1 || escape[Fnr][Fnc] == '#') {
					continue;
				}
				distF[Fnr][Fnc] = distF[tmpFR][tmpFC] + 1;
				F.add(new Location(Fnr, Fnc));
			}
		}
		while (!Q.isEmpty()) {
			Location tmpJ = Q.poll();
			int tmpR = tmpJ.row;
			int tmpC = tmpJ.col;

			for (int i = 0; i < 4; i++) {
				int Jnr = tmpR + dr[i];
				int Jnc = tmpC + dc[i];

				if (Jnr < 0 || Jnc < 0 || Jnr >= R || Jnc >= C) {
					System.out.println(distJ[tmpR][tmpC]);
					return;
				}
				if (distJ[Jnr][Jnc] >= 1 || escape[Jnr][Jnc] == '#') {
					continue;
				}
				if(distF[Jnr][Jnc] != 0 && distF[Jnr][Jnc] <=  distJ[tmpR][tmpC]+1) {
					continue;
				}
				
				distJ[Jnr][Jnc] = distJ[tmpR][tmpC]+1;
				Q.add(new Location(Jnr, Jnc));
				
			}

		}

		System.out.println("IMPOSSIBLE");

	}

}
