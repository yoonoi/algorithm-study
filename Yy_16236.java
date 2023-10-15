package bonus.babyShark;
import java.util.*;

public class Yy_16236_맞는거 {

    static int n, eat, ans;
    static int[][] board;
    static int size = 2;
    static final int BABY_SHARK = 9;
    static int[] babyShark = new int[2]; // 아기상어의 좌표를 저장
    
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static class Node implements Comparable<Node> {
        int x;
        int y;
        int distance;

        public Node(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o) {
        	if(this.distance != o.distance)
        		return this.distance - o.distance;

            if(this.x != o.x)
                return this.x - o.x;

            return this.y - o.y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        board = new int[n][n];
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                board[i][j] = sc.nextInt();

                if(board[i][j] == BABY_SHARK){
                	babyShark = new int[] {i, j};
                    board[i][j] = 0; // 아기상어는 맵에 표시해주지 않는다.
                }
            }
        }

        eat = 0; // 먹은 물고기 수 (사이즈확인용)
        ans = 0; // 시간
        eatFish();
    }

    static void eatFish() {
    	
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[][] visited = new boolean[n][n];
        
        pq.offer(new Node(babyShark[0], babyShark[1], 0));
        visited[babyShark[0]][babyShark[1]] = true;
        
        boolean canEat = false;

        while(!pq.isEmpty()) {
            Node now = pq.poll();
            int x = now.x;
            int y = now.y;
            int distance = now.distance;
            
            if(canEat(x, y, size)) {
            	board[x][y]= 0;
            	eat++;
            	ans += distance;
            	
            	if(eat == size) {
            		size++;
            		eat = 0;
            	}
            	
            	babyShark[0] = x;
            	babyShark[1] = y;
            	
            	canEat = true;
            	break;
            }

            for(int i=0; i<4; i++) {
                int nr = x + dr[i];
                int nc = y + dc[i];

                if(isOutOfRange(nr, nc)) continue;
                
                if(visited[nr][nc]) continue;

                if(isBig(nr, nc, size)) continue;

                pq.offer(new Node(nr, nc, distance + 1));
                visited[nr][nc] = true;
            }
        }
        
        if(!canEat) {
        	System.out.println(ans);
        	return;
        }
        
        eatFish();
    }

    static boolean isOutOfRange(int x, int y) {
        return x < 0 || y < 0 || x >= n || y >= n;
    }

    static boolean isBig(int x, int y, int size) {
        return board[x][y] > size;
    }

    static boolean move(int x, int y, int size) {
        return board[x][y] == size || board[x][y] == 0;
    }

    static boolean canEat(int x, int y, int size) {
        return board[x][y] < size && board[x][y] != 0;
    }
}