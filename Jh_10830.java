import java.util.Scanner;

public class Jh_10830 {
    static int n;
    static long b;
    static final int DIV = 1000;
    static int[][] matrix;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        b = sc.nextLong();

        matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = sc.nextInt() % DIV;
            }
        }
        int[][] answer = solution(matrix, b);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] pow(int[][] arr, int[][] arr2) {
        int[][] tmp = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int num = 0;
                for (int k = 0; k < n; k++) {
                    num += arr[i][k] * arr2[k][j];
                    num %= DIV;
                }
                tmp[i][j] = num;
            }
        }
        return tmp;
    }

    public static int[][] solution(int[][] arr, long exp) {
        if (exp == 1L) return arr;
        int[][] tmp = solution(arr, exp / 2);
        tmp = pow(tmp, tmp);
        if (exp % 2 == 1L) {
            tmp = pow(tmp, matrix);
        }
        return tmp;
    }
}
