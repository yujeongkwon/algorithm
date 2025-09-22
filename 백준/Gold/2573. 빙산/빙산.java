import java.io.*;
import java.util.*;

public class Main {
    static int n,m;
    static int[][] bing;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        bing = new int[n][m];
        for(int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                bing[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    
        int year = 0;
        while(true){
            int cnt = getSeparateCnt();  // 🔥 분리된 덩어리 개수
            if(cnt == 0){   // 다 녹음
                System.out.println(0);
                return;
            }
            if(cnt >= 2){  // 두 덩어리 이상
                System.out.println(year);
                return;
            }
            getOneYearsLater(); // 1년 후
            year++;
        }
    }
    
    public static int getSeparateCnt() {
        boolean[][] visited = new boolean[n][m];
        int iceCnt = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++){
                if(bing[i][j] > 0 && !visited[i][j]){
                    iceLump(i,j, visited);
                    iceCnt++;
                }
            }
        }
        return iceCnt;
    }

    public static void getOneYearsLater() {
        int[][] minus = new int[n][m];

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                if(bing[i][j] > 0) {
                    int water = 0;
                    for(int d=0; d<4; d++) {
                        int nx = i+dx[d];
                        int ny = j+dy[d];
                        if(isPossible(nx,ny) && bing[nx][ny] == 0) {
                            water++;
                        }
                    }
                    minus[i][j] = water;
                }
            }
        }

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                bing[i][j] = Math.max(0, bing[i][j] - minus[i][j]);
            }
        }
    }

    public static void iceLump(int i, int j, boolean[][] visited) {
        visited[i][j] = true;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i,j});
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            for(int d=0; d<4; d++){
                int nx = cur[0]+dx[d];
                int ny = cur[1]+dy[d];
                if(isPossible(nx,ny) && bing[nx][ny] > 0 && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    q.offer(new int[]{nx,ny});
                }
            }
        }
    }

    public static boolean isPossible(int i, int j) {
        return (i>=0 && i<n && j>=0 && j<m);
    }
}
