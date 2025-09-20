import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    static int n,m;
    static int[][] map;
    static boolean[][] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];
        
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int max = 0;
        int cnt = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(!visited[i][j] && map[i][j]==1) {
                    cnt++;
                    max = Math.max(max,bfs(i,j));
                }
            }
        }
        
        System.out.println(cnt);
        System.out.print(max);
        
    }
    
    public static int bfs(int i, int j) {
        int[] dx = new int[]{1,-1,0,0};
        int[] dy = new int[]{0,0,1,-1};
        
        int cnt = 0;
        LinkedList<int[]> q = new LinkedList<>();
        q.push(new int[]{i,j});
        visited[i][j] = true;
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            cnt++;
            
            
            for(int idx=0; idx<4; idx++) {
                int nx = cur[0] + dx[idx];
                int ny = cur[1] + dy[idx];
                if(isPossible(nx,ny) && !visited[nx][ny] && map[nx][ny]==1) {
                    q.offer(new int[]{nx,ny});
                    visited[nx][ny] = true;
                }
            }
        }
        
        return cnt;
    }
    
    public static boolean isPossible(int x, int y){
        if (x>=0 && y>=0 && x<n && y<m) {
            return true;
        }
        return false;
    }
}
