import java.util.Scanner;

public class Jh_2630 {
    public static int white = 0;
    public static int blue = 0;
    public static int[][] map;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int N = in.nextInt();

        map = new int[N][N];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                map[i][j] = in.nextInt();
            }
        }

        partition(0, 0, N);

        System.out.println(white);
        System.out.println(blue);

    }

    public static void partition(int row, int col, int size) {

        //
        if(colorCheck(row, col, size)) {
            if(map[row][col] == 0) {
                white++;
            }
            else {
                blue++;
            }
            return;
        }

        int newSize = size / 2;
        partition(row, col, newSize);
        partition(row, col + newSize, newSize);
        partition(row + newSize, col, newSize);
        partition(row + newSize, col + newSize, newSize);
    }



    public static boolean colorCheck(int row, int col, int size) {

        int color = map[row][col];

        for(int i = row; i < row + size; i++) {
            for(int j = col; j < col + size; j++) {
                if(map[i][j] != color) {
                    return false;
                }
            }
        }
        return true;
    }
}