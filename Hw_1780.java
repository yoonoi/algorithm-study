import java.util.*;

public class Hw_1780 {
	static int minusArea;
	static int zeroArea;
	static int plusArea;
	static int[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		isFill(N, 0, 0);
		System.out.println(minusArea);
		System.out.println(zeroArea);
		System.out.println(plusArea);
	}

	public static void isFill(int size, int startRow, int startCol) {

		int sum = 0;
		int startNum = map[startRow][startCol];
		for (int i = startRow; i < startRow + size; i++) {
			for (int j = startCol; j < startCol + size; j++) {
				if(map[i][j] != startNum) {
					isFill(size / 3, startRow, startCol);
					isFill(size / 3, startRow, startCol + size / 3);
					isFill(size / 3, startRow, startCol + size / 3 * 2);
					isFill(size / 3, startRow + size / 3, startCol);
					isFill(size / 3, startRow + size / 3, startCol + size / 3);
					isFill(size / 3, startRow + size / 3, startCol + size / 3 * 2);
					isFill(size / 3, startRow + size / 3 * 2, startCol);
					isFill(size / 3, startRow + size / 3 * 2, startCol + size / 3);
					isFill(size / 3, startRow + size / 3 * 2, startCol + size / 3 * 2);
					return;
				}
			}
		}
		
		if (startNum == -1) {
			minusArea++;
			return;
		} else if (startNum == 0) {
			zeroArea++;
			return;
		} else if (startNum == 1) {
			plusArea++;
			return;
		}

		
	}
}
