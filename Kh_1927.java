import java.util.PriorityQueue;
import java.util.Scanner;

public class Kh_1927 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PriorityQueue<Integer> priorityQueueLowest = new PriorityQueue<>();
		
		
		int N = sc.nextInt();
		
		for(int i = 0 ; i < N ; i++) {
			int a = sc.nextInt();
			
			if(a==0) {
				if(priorityQueueLowest.isEmpty()) {
					System.out.println(0);
				}else {
					System.out.println(priorityQueueLowest.poll());
				}
			}else {
				priorityQueueLowest.add(a);
			}
			
			
		}
		
	}

}
