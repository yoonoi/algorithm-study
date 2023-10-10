import java.util.*;

public class Hw_2468 {

	private static int N;
	private static int[][] arr;
	private static boolean[][] visited;
	
	private static int cnt =0;
	private static int waterMax = 0;
	private static int answer = 0;
	private static int[] dx = {0,0,1,-1};
	private static int[] dy = {1,-1,0,0};
	
	public static void main(String[] args) {
		//입력 데이터 저장
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		sc.nextLine();
		arr = new int[N][N];

		for(int i=0; i<N;i++) {
			for(int j = 0; j<N;j++) {
				int value = sc.nextInt();
				arr[i][j] = value;
				waterMax = Math.max(waterMax, arr[i][j]); //물높이 최대값 찾기
				
			}
		}
		
		
		//dfs 검색
		for(int k =0;k<=waterMax;k++) { // 0 ~ 물높이 최댓값만큼 반복
            //방문체크와 카운트 리셋 
			visited = new boolean[N][N];
			cnt = 0;
			
			for(int i=0; i<N;i++) {
				for(int j = 0; j<N;j++) {
				if(arr[i][j]>k && !visited[i][j]) {
					dfs(i,j,k);
					cnt++;
					}
				}
			}
			answer = Math.max(answer, cnt);		
			}
		System.out.println(answer);
	}
	
	private static void dfs(int x, int y,int waterHeigh) {
		visited[x][y] = true;
		for(int i=0; i<4;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx>=0 && ny>=0 && nx<N && ny<N) {
				if(arr[nx][ny] > waterHeigh && !visited[nx][ny]) {
					dfs(nx,ny,waterHeigh);
				}
			}
		}
	}

}