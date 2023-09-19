package gold;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Kh_1766 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int N = sc.nextInt();
		int M = sc.nextInt();

		int[] problems = new int[N + 1];
		ArrayList<ArrayList<Integer>> linked = new ArrayList<>();

		for (int i = 0; i <= N; i++) {
			linked.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			int former = sc.nextInt();
			int latter = sc.nextInt();

			linked.get(former).add(latter);

			problems[latter]++;
		}

		 PriorityQueue<Integer> q = new PriorityQueue<>();

		for (int i = 1; i <= N; i++) {
			if (problems[i] == 0) {
				q.add(i);
			}
		}
		
		for (int i = 1; i <= N; i++) {
			int tmp = q.poll();
			
			sb.append(tmp).append(" ");

			Collections.sort(linked.get(tmp));
			for (int l = 0; l < linked.get(tmp).size(); l++) {
				int next = linked.get(tmp).get(l);
				problems[next]--;
				if (problems[next]== 0) {
					q.add(next);
				}
			}

		}
		
		System.out.println(sb);

	}
}
