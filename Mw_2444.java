import java.util.Scanner;

public class Mw_2444 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 임의의 수 N을 입력 받자.
        int N = sc.nextInt();

        // 윗 부분의 삼각형을 출력하자.
        for(int row = 0; row < N; row++) {
            for(int col = 0; col < N + row; col++) {
                if(row + col >= N-1) {
                    if(col == N+row-1) {
                        System.out.println("*");
                    } else {
                        System.out.print("*");
                    }
                } else {
                    System.out.print(" ");
                }
            }
        }

        // 아랫 부분의 삼각형을 마저 출력해보자.
        for(int row = 0; row < N-1; row++) {
            for(int col = 0; col < (2*N-2)-row; col++) {
                if(col > row) {
                    if(col == 2*N-3-row) {
                        System.out.println("*");
                    } else {
                        System.out.print("*");
                    }
                } else {
                    System.out.print(" ");
                }
            }
        }
    }
}
