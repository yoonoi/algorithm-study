package friday;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Yy_5430 {
	
	static String[] arr;
	static List<String> list = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=0; tc<T; tc++) {
			String input = br.readLine(); // 수행할 함수
			int n = Integer.parseInt(br.readLine());

			String str = br.readLine();
			str = str.substring(1, str.length()-1);
			arr = str.split(",");
			
			list = new ArrayList<>();
			for(int i=0; i<n; i++) 
				list.add(arr[i]);
			
			method(input);
		}
	}
	
	static void method(String input) {
		for(int i=0; i<input.length(); i++) {
			char c = input.charAt(i);
			
			if(c == 'R') {
				Collections.reverse(list);
			}
			
			if(c == 'D') {
				if(list.size() == 0) {
					System.out.println("error");
					return;
				}
				
				list.remove(0);
			}
		}
		
		System.out.println(list);
		
	}

}