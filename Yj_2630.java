import java.io.*;

public class Yj_2630 {
    static int white = 0;
    static int blue = 0;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());

        map = new int[size][size];

        for (int i = 0; i < size; i++) {
            String[] arr = br.readLine().split(" ");

            for (int j = 0; j < size; j++) {
                map[i][j] = Integer.parseInt(arr[j]);
            }
        }

        find(0, 0, size);

        System.out.println(white);
        System.out.println(blue);
    }

    public static void find(int row, int col, int size) {
        if (check(row, col, size)) {
            if (map[row][col] == 0){
                white++;
            } else {
                blue++;
            }
            return;
        }

        int half = size / 2;

        find(row, col, half);
        find(row, col + half, half);
        find(row + half, col, half);
        find(row + half, col + half, half);
    }

    public static boolean check(int row, int col, int size) {
        int s = map[row][col];

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (map[i][j] != s) {
                    return false;
                }
            }
        }
        return true;
    }
}