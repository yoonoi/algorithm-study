import java.util.Arrays;
import java.util.Scanner;

public class Kh_1920 {
	static int N, M;
	static int[] searched;
	static boolean isExist;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		N = sc.nextInt();
		searched = new int[N];
		for (int i = 0; i < N; i++) {
			searched[i] = sc.nextInt();
		}
		Arrays.sort(searched);

		M = sc.nextInt();
		for (int i = 0; i < M; i++) {
			int searching = sc.nextInt();
			isExist = false;
			binarysearch(searching, 0, N - 1);
			if (isExist) {
				sb.append(1).append('\n');
			} else {
				sb.append(0).append('\n');
			}
		}
		
		System.out.println(sb);
	}

	private static void binarysearch(int searching, int start, int end) {
		if(start > end) {
			return;
		}
		
		int mid = (start + end) / 2;
		
		if (searched[mid] == searching) {
			isExist = true;
			return;			
		}

		if (searching < searched[mid] ) {
			binarysearch(searching, start, mid-1);
			return;
		} else if (searching > searched[mid] ) {
			binarysearch(searching, mid+1, end);
			return;
		}

	}

}
