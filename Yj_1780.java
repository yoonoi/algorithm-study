import java.io.*;

public class Yj_1780 {

    static int[][] map;
    static int gray = 0;
    static int white = 0;
    static int black = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());
        map = new int[size][size];

        for(int i = 0; i < size; i++) {
            String[] arr = br.readLine().split(" ");
            for(int j = 0; j < size; j++) {
                map[i][j] = Integer.parseInt(arr[j]);
            }
        }

        find(0, 0, size);

        System.out.println(gray);
        System.out.println(white);
        System.out.println(black);
    }

    public static void find(int row, int col, int size) {
        if(check(row, col, size)) {
            if(map[row][col] == -1) {
                gray++;
            } else if(map[row][col] == 0) {
                white++;
            } else {
                black++;
            }
            return;
        }

        int ns = size / 3;

        find(row, col, ns);
        find(row, col + ns, ns);
        find(row, col + 2 * ns, ns);

        find(row + ns, col, ns);
        find(row + ns, col + ns, ns);
        find(row + ns, col + 2 * ns, ns);

        find(row + 2 * ns, col, ns);
        find(row + 2 * ns, col + ns, ns);
        find(row + 2 * ns, col + 2 * ns, ns);
    }

    public static boolean check(int row, int col, int size) {
        int s = map[row][col];

        for(int i = row; i < row + size; i++) {
            for(int j = col; j < col + size; j++) {
                if(s != map[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}