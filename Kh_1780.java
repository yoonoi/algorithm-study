package silver;

import java.util.Scanner;

public class Kh_1780 {
	static int[][] paper;
	static int N, countPositive, countZero, countNegative;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		paper = new int[N][N];

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				paper[r][c] = sc.nextInt();
			}
		}

		countNegative = 0;
		countZero = 0;
		countPositive = 0;
		paperCut(0, N, 0, N);
		System.out.println(countNegative);
		System.out.println(countZero);
		System.out.println(countPositive);

	}

	public static void paperCut(int startR, int endR, int startC, int endC) {
		if (startR >= endR || startC >= endC) {
			return;
		}
		if (isPositive(startR, endR, startC, endC)) {
			countPositive++;
			return;
		}
		if (isZero(startR, endR, startC, endC)) {
			countZero++;
			return;
		}
		if (isNegative(startR, endR, startC, endC)) {
			countNegative++;
			return;
		}

		paperCut(startR, startR + (endR - startR) / 3, startC, startC + (endC - startC) / 3);
		paperCut(startR, startR + (endR - startR) / 3, startC + (endC - startC) / 3, startC + (endC - startC) * 2 / 3);
		paperCut(startR, startR + (endR - startR) / 3, startC + (endC - startC) * 2 / 3, endC);
		paperCut(startR + (endR - startR) / 3, startR + (endR - startR) * 2 / 3, startC, startC + (endC - startC) / 3);
		paperCut(startR + (endR - startR) / 3, startR + (endR - startR) * 2 / 3, startC + (endC - startC) / 3,
				startC + (endC - startC) * 2 / 3);
		paperCut(startR + (endR - startR) / 3, startR + (endR - startR) * 2 / 3, startC + (endC - startC) * 2 / 3,
				endC);
		paperCut(startR + (endR - startR) * 2 / 3, endR, startC, startC + (endC - startC) / 3);
		paperCut(startR + (endR - startR) * 2 / 3, endR, startC + (endC - startC) / 3,
				startC + (endC - startC) * 2 / 3);
		paperCut(startR + (endR - startR) * 2 / 3, endR, startC + (endC - startC) * 2 / 3, endC);

	}

	private static boolean isNegative(int startR, int endR, int startC, int endC) {
		boolean flag = true;
		here: for (int r = startR; r < endR; r++) {
			for (int c = startC; c < endC; c++) {
				if (paper[r][c] != -1) {
					flag = false;
					break here;
				}
			}
		}
		return flag;
	}

	private static boolean isZero(int startR, int endR, int startC, int endC) {
		boolean flag = true;
		here: for (int r = startR; r < endR; r++) {
			for (int c = startC; c < endC; c++) {
				if (paper[r][c] != 0) {
					flag = false;
					break here;
				}
			}
		}
		return flag;
	}

	private static boolean isPositive(int startR, int endR, int startC, int endC) {
		boolean flag = true;
		here: for (int r = startR; r < endR; r++) {
			for (int c = startC; c < endC; c++) {
				if (paper[r][c] != 1) {
					flag = false;
					break here;
				}
			}
		}
		return flag;
	}

}
