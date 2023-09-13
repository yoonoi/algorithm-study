import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Yj_0920 {
	static int[] num;
	static int[] checkNum;
	static boolean check;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");
		num = new int[input.length];

		for (int i = 0; i < num.length; i++) {
			num[i] = Integer.parseInt(input[i]);
		}
		Arrays.sort(num);
		N = Integer.parseInt(br.readLine());
		input = br.readLine().split(" ");
		checkNum = new int[input.length];
		for (int i = 0; i < checkNum.length; i++) {
			checkNum[i] = Integer.parseInt(input[i]);
		}
		for (int i = 0; i < checkNum.length; i++) {
			check = false;
			binarySearch(checkNum[i], 0, num.length - 1);
			if (check) {
				System.out.println(1);
			} else {
				System.out.println(0);
			}
		}
	}

	static void binarySearch(int target, int left, int right) {
		if (left > right) {
			return;
		}

		int mid = (left + right) / 2;
		if (num[mid] == target) {
			check = true;
		} else if (num[mid] > target) {
			binarySearch(target, left, mid - 1);
		} else {
			binarySearch(target, mid + 1, right);
		}
	}
}