import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Yj_10816 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static int[] checkCard;
	static int[] answer;
	static HashMap<Integer, Integer> map;

	static void input() throws NumberFormatException, IOException {
		map = new HashMap<>();

		int sangNum = Integer.parseInt(br.readLine());

		String[] input = br.readLine().split(" ");
		for (int i = 0; i < input.length; i++) {
			int key = Integer.parseInt(input[i]);
			map.put(key, map.getOrDefault(key, 0) + 1);
		}

		int checkNum = Integer.parseInt(br.readLine());
		input = br.readLine().split(" ");
		answer = new int[input.length];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = Integer.parseInt(input[i]);
		}
	}

	static void findNum() {
		for (int i = 0; i < answer.length; i++) {
			sb.append(map.getOrDefault(answer[i], 0)).append(" ");
		}
	}

	static void solve() throws NumberFormatException, IOException {
		input();
		findNum();
		System.out.println(sb);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		solve();
	}
}
