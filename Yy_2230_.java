package twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Yy_2230 {

    static int n, m, ans;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        for(int i=0; i<n; i++)
            arr[i] = Integer.parseInt(br.readLine());

        Arrays.sort(arr); // 오름차순으로 정렬한 뒤

        ans = Integer.MAX_VALUE;

        twoPointer();
        System.out.println(ans);
    }

    static void twoPointer() {
        // 1. s <= e
        // 2. start와 end는 현재 부분배열의 시작과 끝을 가리킴
        // 3. s는 포함 e는 불포함, 즉 s==e일 경우는 크기가 0인 부분배열
        // 4. s < N(arr의크기)인 동안 반복

        // 현재 부분합이 M이상이거나, 이미 e = N이면 s++
        // 그 외에는 모두 e++
        // 현재 부분합이 M과 같으면 결과 카운트 ++

        int start = 0, end = 0;

        while(start <= end && end < n) {
            int gap = arr[end] - arr[start];

            if(gap < m){
                end++;
                continue;
            }

            if(gap == m) {
                ans = m;
                break;
            }

            ans = Math.min(gap, ans);
            start++;


//            if(gap >= m && gap < ans)
//                ans = gap;
//
//            if(gap < m || end == n)
//                start++;
//            else
//                end++;
        }
    }

}
