import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Kh_11279 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		PriorityQueue<Integer> priorityQueueHighest = new PriorityQueue<>(Collections.reverseOrder());
		
		
		int N = sc.nextInt();
		
		for(int i = 0 ; i < N ; i++) {
			int a = sc.nextInt();
			
			if(a==0) {
				if(priorityQueueHighest.isEmpty()) {
					System.out.println(0);
					continue;
				}
				System.out.println(priorityQueueHighest.poll());
			}else {
				priorityQueueHighest.add(a);
			}		
		}
	}

}
