import java.util.*;

public class Hw_11279 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
		
		int N = sc.nextInt();
		for(int i = 0; i < N; i++) {
			int command = sc.nextInt();
			if(command != 0) {
				priorityQueue.add(command);
			}
			else {
				if(priorityQueue.isEmpty()) {
					sb.append(0).append('\n');
				}
				else {
					sb.append(priorityQueue.poll()).append('\n');
				}
			}
		}
		
		System.out.println(sb);
		
		
	}
}
