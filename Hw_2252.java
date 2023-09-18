import java.util.*;

public class Hw_2252 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] array = new int[N + 1];
		int[][] relation = new int[M][2];
		Queue<Integer> queue = new LinkedList<>();
		ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < N + 1; i++) {
			arr.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			int first = sc.nextInt();
			int second = sc.nextInt();
			arr.get(first).add(second);
			array[second]++;
		}
		for (int i = 1; i <= N; i++) {
			if (array[i] == 0) {
				queue.add(i);
			}
		}

		while(!queue.isEmpty()) {
			int now = queue.poll();
			sb.append(now).append(" ");
			for(int near: arr.get(now)) {
				array[near]--;
				if(array[near] == 0) {
					queue.add(near);
				}
			}
		}
		System.out.println(sb);
	}
}
