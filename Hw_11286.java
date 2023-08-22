import java.util.*;

public class Hw_11286 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> priorityQueueMax = new PriorityQueue<>(Comparator.reverseOrder());
		PriorityQueue<Integer> priorityQueueMin = new PriorityQueue<>();
		int N = sc.nextInt();

		for (int i = 0; i < N; i++) {
			int command = sc.nextInt();

			if (command != 0) {
				if (command > 0) {
					priorityQueueMin.add(command);
				} else {
					priorityQueueMax.add(command);
				}
			} else {
				if (priorityQueueMin.isEmpty() && priorityQueueMax.isEmpty()) {
					sb.append(0).append('\n');
				} else {
					if (priorityQueueMin.isEmpty()) {
						sb.append(priorityQueueMax.poll()).append('\n');
					} else if (priorityQueueMax.isEmpty()) {
						sb.append(priorityQueueMin.poll()).append('\n');
					} else if (priorityQueueMin.peek() < Math.abs(priorityQueueMax.peek())) {
						sb.append(priorityQueueMin.poll()).append('\n');
					} else {
						sb.append(priorityQueueMax.poll()).append('\n');
					}
				}
			}
		}
		System.out.println(sb);
	}
}
