import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
 
public class Hw_7569 {
 
    static int dx[] = { -1, 0, 1, 0 };
    static int dy[] = { 0, 1, 0, -1 };
    static int dh[] = {-1, 1};
    static int N, M, H, cntZero, res, map[][][];
    static Queue<pnt> q;
 
    static public class pnt {
        int h;
        int x;
        int y;
 
        public pnt(int h, int x, int y) {
            this.h = h;
            this.x = x;
            this.y = y;
        }
    }
 
    public static void main(String[] args) throws IOException {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
 
        st = new StringTokenizer(br.readLine(), " ");
        M = Integer.parseInt(st.nextToken()); // 가로
        N = Integer.parseInt(st.nextToken()); // 세로
        H = Integer.parseInt(st.nextToken());
        map = new int[H][N][M];
        q = new LinkedList<>();
        cntZero = 0;
        for (int h = 0; h < H; h++) {
            for (int x = 0; x < N; x++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int y = 0; y < M; y++) {
                    map[h][x][y] = Integer.parseInt(st.nextToken());
                    // 익은 토마토의 위치를 Queue에 add
                    if (map[h][x][y] == 1) q.offer(new pnt(h, x, y));
                    // 익지 않은 토마토 count
                    if (map[h][x][y] == 0) cntZero++;
                }
            }
        }
        // 모든 토마토가 익어있는 상태라면
        if(cntZero == 0) {
            System.out.println("0");
            return;
        }
        
        res = -1;
        bfs();
        
        // 아직 덜 익은 토마토가 있다면
        if(cntZero != 0) System.out.println("-1");
        else System.out.println(res);
    }
    
    public static void bfs() {
        // 익은 토마토의 위치를 Queue에서 꺼내면서 주변 토마토를 익혀보자
        while (!q.isEmpty()) {
            // 현재 Queue Size를 미리 저장
            int tmpN = q.size();
            res++;
            for (int day = 0; day < tmpN; day++) {
                pnt tmp = q.poll();
                // 인접한 안 익은 토마토 찾기(상,하,좌,우)
                for (int i = 0; i < 4; i++) {
                    int xx = tmp.x + dx[i];
                    int yy = tmp.y + dy[i];
                    // 범위를 벗어날 경우 pass
                    if(xx < 0 || yy < 0 || xx >= N || yy>=M) continue;
                    // 인접한 토마토가 익지 않았다면 익혀주고 Queue에 넣기
                    if(map[tmp.h][xx][yy] == 0) {
                        map[tmp.h][xx][yy] = 1;
                        cntZero--;
                        q.offer(new pnt(tmp.h, xx, yy));
                    }
                }
                // 인접한 안 익은 토마토 찾기(위,아래)
                for (int i = 0; i < 2; i++) {
                    int hh = tmp.h + dh[i];
                    // 범위를 벗어날 경우 pass
                    if(hh < 0 || hh >= H) continue;
                    // 인접한 토마토가 익지 않았다면 익혀주고 Queue에 넣기
                    if(map[hh][tmp.x][tmp.y] == 0) {
                        map[hh][tmp.x][tmp.y] = 1;
                        cntZero--;
                        q.offer(new pnt(hh, tmp.x, tmp.y));
                    }
                }
            }
        }
    }
}