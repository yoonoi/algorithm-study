import java.util.*;

public class Hw_10816 {
	static int[] result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = sc.nextInt();
		int[] count = new int[20000001];
		for (int i = 0; i < N; i++) {
			int num = sc.nextInt();
			count[num + 10000000]++;
		}
		int M = sc.nextInt();
		int[] arr = new int[M];
		result = new int[M];
		for (int i = 0; i < M; i++) {
			int num = sc.nextInt();
			sb.append(count[num + 10000000]).append(" ");
		}
		System.out.println(sb);
	}

}
