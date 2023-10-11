import java.util.*;

public class Hw_15686 {
	static int N, M;
	static int[][] map;
	static int result = Integer.MAX_VALUE;
	static ArrayList<Location> home = new ArrayList<>();
	static ArrayList<Location> store = new ArrayList<>();
	static boolean[] selected;

	static class Location {
		int r, c;

		public Location(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] == 1) {
					home.add(new Location(i, j));
				} else if (map[i][j] == 2) {
					store.add(new Location(i, j));
				}
			}
		}
		selected = new boolean[store.size()];
		backtracking(0, 0);
		System.out.println(result);
	}

	public static void backtracking(int count, int idx) {
		if (count == M) {
			int distance = 0;
			for (int i = 0; i < home.size(); i++) {
				int sum = Integer.MAX_VALUE;
				for (int j = 0; j < store.size(); j++) {
					if (selected[j]) {
						int dist = Math.abs(home.get(i).r - store.get(j).r) + Math.abs(home.get(i).c - store.get(j).c);
						sum = Math.min(sum, dist);
					}
				}
				distance += sum;
			}
			result = Math.min(distance, result);
			return;
		}

		for (int i = idx; i < store.size(); i++) {
			if (!selected[i]) {
				selected[i] = true;
				backtracking(count + 1, i + 1);
				selected[i] = false;
			}
		}
	}
}