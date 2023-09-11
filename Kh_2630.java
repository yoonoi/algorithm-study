package silver;

import java.util.Scanner;

public class Kh_2630 {
	static int[][] paper;
	static int N, countBlue, countWhite;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		paper = new int[N][N];
		for(int r = 0 ; r < N ; r++) {
			for(int c = 0 ; c < N ; c++) {
				paper[r][c] = sc.nextInt();
			}
		}
		countBlue = 0;
		countWhite = 0;
		paperCut(0, N, 0, N);
		System.out.println(countWhite);
		System.out.println(countBlue);

	}

	public static void paperCut(int startR, int endR, int startC, int endC) {
		if(startR>= endR || startC >= endC) {
			return;
		}
		if (isFullBlue(startR, endR, startC, endC)) {
			countBlue++;
			return;
		}
		if (isFullWhite(startR, endR, startC, endC)) {
			countWhite++;
			return;
		}
		
		paperCut(startR, (startR+endR)/2, startC, (startC+endC)/2);
		paperCut(startR, (startR+endR)/2, (startC+endC)/2, endC);
		paperCut((startR+endR)/2, endR, startC, (startC+endC)/2);
		paperCut((startR+endR)/2, endR, (startC+endC)/2, endC);
	


	}

	public static boolean isFullBlue(int startR, int endR, int startC, int endC) {
		boolean flag = true;
		here: for (int r = startR; r < endR; r++) {
			for (int c = startC; c < endC; c++) {
				if (paper[r][c] == 0) {
					flag = false;
					break here;
				}
			}
		}
		return flag;
	}

	public static boolean isFullWhite(int startR, int endR, int startC, int endC) {
		boolean flag = true;
		here: for (int r = startR; r < endR; r++) {
			for (int c = startC; c < endC; c++) {
				if (paper[r][c] == 1) {
					flag = false;
					break here;
				}
			}
		}
		return flag;
	}
}
