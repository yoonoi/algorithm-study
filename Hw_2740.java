import java.util.*;

public class Hw_2740 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int aRow = sc.nextInt();
		int aCol = sc.nextInt();
		int[][] a = new int[aRow][aCol];
		for (int i = 0; i < aRow; i++) {
			for (int j = 0; j < aCol; j++) {
				a[i][j] = sc.nextInt();
			}
		}

		int bRow = sc.nextInt();
		int bCol = sc.nextInt();
		int[][] b = new int[bRow][bCol];
		for (int i = 0; i < bRow; i++) {
			for (int j = 0; j < bCol; j++) {
				b[i][j] = sc.nextInt();
			}
		}

		int[][] ab = new int[aRow][bCol];

		for (int i = 0; i < aRow; i++) {
			for (int j = 0; j < bCol; j++) {
				for(int k = 0; k < aCol; k++) {
					int aNum = a[i][k];
					int bNum = b[k][j];
					ab[i][j] += aNum * bNum;
				}
				
			}
		}

		for (int i = 0; i < aRow; i++) {
			for (int j = 0; j < bCol; j++) {
				System.out.print(ab[i][j] + " ");
			}
			System.out.println();
		}
	}
}
