import java.util.*;

public class Hw_2630 {
	static int whiteArea;
	static int blueArea;
	static int[][] paper;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		paper = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				paper[i][j] = sc.nextInt();
			}
		}

		isFill(N, 0, 0);
		System.out.println(whiteArea);
		System.out.println(blueArea);
	}

	public static void isFill(int size, int startRow, int startCol) {

		int color = 0;

		for (int i = startRow; i < startRow + size; i++) {
			for (int j = startCol; j < startCol + size; j++) {
				color += paper[i][j];
			}
		}

		if (color == 0) {
			whiteArea++;
			return;
		} else if (color == size * size) {
			blueArea++;
			return;
		}

		isFill(size / 2, startRow, startCol + (size / 2)); // 1사분면
		isFill(size / 2, startRow, startCol); // 2사분면
		isFill(size / 2, startRow + (size / 2), startCol); // 3사분면
		isFill(size / 2, startRow + (size / 2), startCol + (size / 2)); // 4사분면

	}
}
