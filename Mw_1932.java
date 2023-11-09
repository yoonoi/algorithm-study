//import java.util.Arrays;
import java.util.Scanner;

public class Mw_1932 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] arr = new int[n][n];

        arr[0][0] = sc.nextInt();
        int num;
        int max = 0;
        if(n > 1) {
            for(int row = 1; row < n; row++) {
                for(int col = 0; col <= row; col++) {
                    if(col == 0) {
                        num = sc.nextInt();
                        arr[row][col] = num + arr[row-1][col];
                    } else {
                        num = sc.nextInt();
                        arr[row][col] = num + Math.max(arr[row-1][col-1], arr[row-1][col]);
                    }

                    if(row == (n-1)) {
                        if(max < arr[row][col]) max = arr[row][col];
                    }
                }
            }
            System.out.println(max);
//            System.out.println(Arrays.deepToString(arr));
        }
        else System.out.println(arr[0][0]);
    }
}
