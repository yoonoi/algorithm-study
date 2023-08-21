import java.util.*;

public class Hw_9663 {
	static int N;
	static int result = 0;
	static boolean[] canLocate1;
	static boolean[] canLocate2;
	static boolean[] canLocate3;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		canLocate1 = new boolean[N];
		canLocate2 = new boolean[N * 2];
		canLocate3 = new boolean[N * 2];
		
		nQueen(0);
		System.out.println(result);
	}

	public static void nQueen(int r) {
		if (r == N) {
			result++;
			return;
		}
		
		for(int i = 0; i < N; i++) {
			if(canLocate1[i] || canLocate2[i - r + N - 1] || canLocate3[i + r]) {
				continue;
			}
			canLocate1[i] = true;
			canLocate2[i - r + N - 1] = true;
			canLocate3[i + r] = true;
			nQueen(r + 1);
			canLocate1[i] = false;
			canLocate2[i - r + N - 1] = false;
			canLocate3[i + r] = false;
		}

	}
}
