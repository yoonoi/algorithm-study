package silver;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Kh_2606 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int Computer = sc.nextInt();
		int link = sc.nextInt();
		
		ArrayList<ArrayList<Integer>> network = new ArrayList<>();
		boolean[] contam = new boolean[Computer+1];
		
		for(int i = 0 ; i <= Computer ; i++) {
			network.add(new ArrayList<Integer>());
		}
		
		
		for(int i = 0 ; i < link ; i++) {
			int from = sc.nextInt();
			int to = sc.nextInt();
			
			network.get(from).add(to);
			network.get(to).add(from);
		}
		
		
		Queue<Integer> Q = new LinkedList<>();
		int count = 0;
		
		Q.add(1);
		
		while(!Q.isEmpty()) {
			int tmp = Q.poll();
			contam[tmp] = true;
			
			for(int i = 0 ; i < network.get(tmp).size() ; i++) {
				int next = network.get(tmp).get(i);
				if(!contam[next]) {
					Q.add(next);
					contam[next]=true;
					count++;
				}
			}
		}
		System.out.println(count);
	}
}
