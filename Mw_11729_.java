import java.util.Scanner;

public class Mw_11729_ {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // 이동 횟수 계산 및 출력 준비
        sb.append((int) (Math.pow(2, n) - 1)).append('\n');

        // 하노이 탑 이동 순서 계산
        hanoi(n, 1, 2, 3);

        // 결과 출력
        System.out.println(sb);
    }

    static void hanoi(int n, int from, int temp, int to) {
        if (n == 1) {
            sb.append(from).append(' ').append(to).append('\n');
            return;
        }

        // n-1 개의 원판을 임시 기둥으로 이동
        hanoi(n - 1, from, to, temp);

        // 가장 큰 원판을 목적 기둥으로 이동
        sb.append(from).append(' ').append(to).append('\n');

        // 임시 기둥에 있는 원판들을 목적 기둥으로 이동
        hanoi(n - 1, temp, from, to);
    }
}
