import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Yj_2805 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static String[] input;
	static int treeLength;
	static int[] hight;
	static long sum;
	static int max;
	static int min;

	static void input() throws NumberFormatException, IOException {
		input = br.readLine().split(" ");
		int treeNum = Integer.parseInt(input[0]);
		treeLength = Integer.parseInt(input[1]);
		hight = new int[treeNum];
		max = 0;
		input = br.readLine().split(" ");
		for (int i = 0; i < treeNum; i++) {
			hight[i] = Integer.parseInt(input[i]);
			if (hight[i] > max) {
				max = hight[i];
			}
		}
		sum = 0;
		min = 0;
		max++;
	}

	static void find() {
		int mid = 0;

		while (min < max) {
			sum = 0;
			mid = (max + min) / 2;

			for (int i = 0; i < hight.length; i++) {
				if (hight[i] - mid > 0) {
					sum += hight[i] - mid;
				}
			}

			if (sum < treeLength) {
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