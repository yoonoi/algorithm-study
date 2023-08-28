import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Yy_1012 {
	
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	
	static int m, n, bugs; // bugs = 배추흰지렁이 수
	static boolean[][] map, visited; 
	static Queue<Point> q = new LinkedList<Point>();
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static void bfs(int row, int col) {
		q.offer(new Point(row, col));
		visited[row][col] = true;
		
		while(!q.isEmpty()) {
			Point pop = q.poll();
			
			for(int i=0; i<4; i++) {
				int newRow = pop.x + dr[i];
				int newCol = pop.y + dc[i];
				
				if(newRow < 0 || newCol < 0 || newRow >= m || newCol >= n) continue;
				
				if(!map[newRow][newCol]) continue;
				
				if(visited[newRow][newCol]) continue;
				
				q.offer(new Point(newRow, newCol));
				visited[newRow][newCol] = true;
			}
		}
		
		bugs++;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=0; tc<T; tc++) {
			st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken()); // 가로
			n = Integer.parseInt(st.nextToken()); // 세로
			
			map = new boolean[m][n];
			visited = new boolean[m][n]; // 여기서는 거리 셀 필요없으니 int말고 boolean으로 생성
			bugs = 0;
			
			int k = Integer.parseInt(st.nextToken()); // 배추 개수
			for(int i=0; i<k; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				
				map[x][y] = true; // 배추가 심어져있으면 true
			}
			
			for(int i=0; i<m; i++) {
				for(int j=0; j<n; j++) {
					// 배추가 심어져있고, 아직 방문한 적이 없으면 bfs 시작
					if(map[i][j] && !visited[i][j])
						bfs(i, j);
				}
			}
			
			sb.append(bugs).append("\n");
		}
		
		System.out.println(sb);
	}
}
