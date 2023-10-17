package twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Yy_1806 {
	
	static int n, s, len;
	static int[] arr, prefixSum;
	static final int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		s = Integer.parseInt(st.nextToken());
		len = INF;
		
		arr = new int[n];
		prefixSum = new int[n+1]; // arr의 누적합을 넣어줄 배열
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			
			// 만약 s랑 동일한 값이 있다면 길이 1을 출력하고 끝내버려
			if(arr[i] == s) {
				System.out.println(1);
				return;
			}
		}
		
		// 누적합 배열의 인덱스는 arr 배열의 인덱스+1
		for(int i=1; i<=n; i++) 
			prefixSum[i] = prefixSum[i-1] + arr[i-1]; // 누적합이 들어감
		
		twoPointer(0, 0);
		System.out.println(len == INF ? 0 : len);
	}
	
	static void twoPointer(int start, int end) {
		
		while(start <= end && end < n) {
			// arr[start] ~ arr[end] 사이의 부분합이 구하고 싶다면,
			// end까지의 누적합 - (start-1)까지의 누적합을 하면 된다.
			// prefix[end+1] = arr[0] + arr[1] + ... + arr[end];
			// prefix[start] = arr[0] + arr[1] + ... + arr[start-1];
			// 둘의 차 ==> arr[start] + arr[start+1] + arr[start+2] + ... + arr[end]; 
			//		 ==> start 와 end 사이의 부분합!
			int tmpSum = prefixSum[end + 1] - prefixSum[start]; // 반복문 돌리면 시간초과나서 누적합 사용! 
			
			// 갱신 가능한 조건이면 갱신해주고
			if(tmpSum >= s && len > end - start + 1) {
				len = end - start + 1;
				
				// 길이가 1일때는 input받을 때 처리했으니 그다음으로 짧은 길이인 2가 되면 끝내버림
				if(len == 2) break;
			}
			
			// 조건이 안되니까 end를 늘려서 확인해보기
			if(tmpSum < s) {
				end++;
				continue;
			}
			
			// 그외조건은 start를 늘리기
			start++;
		}
	}
	
}
