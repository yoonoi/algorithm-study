import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class YJ_1012 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int count;
    static int map[][];
    static int[] yIdx = { -1, 0, 1, 0 };
    static int[] xIdx = { 0, 1, 0, -1 };
    static int moveCol;
    static int moveRow;

    static void input() throws NumberFormatException, IOException {
        String[] arr = br.readLine().split(" ");
        int row = Integer.parseInt(arr[0]);
        int col = Integer.parseInt(arr[1]);
        int amount = Integer.parseInt(arr[2]);

        map = new int[col][row];
        count = 0;
        moveCol = 0;
        moveRow = 0;

        for (int i = 1; i <= amount; i++) {
            String[] wich = br.readLine().split(" ");
            int nowRow = Integer.parseInt(wich[0]);
            int nowCol = Integer.parseInt(wich[1]);
            map[nowCol][nowRow]++;
        }
    }

    static void countBug() {
        for (int col = 0; col < map.length; col++) {
            for (int row = 0; row < map[0].length; row++) {
                if (map[col][row] == 1) {
                    count++;
                    move(col, row);
                }
            }
        }
    }

    static void move(int col, int row) {
        map[col][row] = 0;
        for (int i = 0; i < 4; i++) {
            int moveCol = col + yIdx[i];
            int moveRow = row + xIdx[i];
            if (moveCol >= 0 && moveRow >= 0 && moveCol < map.length && moveRow < map[0].length) {
                int newCol = moveCol;
                int newRow = moveRow;
                if (map[newCol][newRow] == 1) {
                    move(newCol, newRow);
                }
            }
        }
    }

    static void solve() throws NumberFormatException, IOException {
        int testCase = Integer.parseInt(br.readLine());
        for (int idx = 1; idx <= testCase; idx++) {
            input();
            countBug();
            System.out.println(count);
        }
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        solve();
    }
}