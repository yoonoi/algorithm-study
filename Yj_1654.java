import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Yj_1654 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static String[] input;
	static int[] num;
	static int need;
	static long answer;
	static long max;
	static long min;

	static void input() throws NumberFormatException, IOException {
		input = br.readLine().split(" ");
		int own = Integer.parseInt(input[0]);
		need = Integer.parseInt(input[1]);
		num = new int[own];
		max = 0;
		min = 0;

		for (int i = 0; i < own; i++) {
			num[i] = Integer.parseInt(br.readLine());
			if (num[i] > max) {
				max = num[i];
			}
		}
		max++;
	}

	static void find() {
		long mid = 0;
		while (min < max) {
			mid = (max + min) / 2;

			long count = 0;

			for (int i = 0; i < num.length; i++) {
				count += (num[i] / mid);
			}

			if (count < need) {
				max = mid;
			} else {
				min = mid + 1;
			}
		}
		sb.append(min - 1);
	}

	static void solve() throws NumberFormatException, IOException {
		input();
		find();
		System.out.println(sb);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		solve();
	}
}