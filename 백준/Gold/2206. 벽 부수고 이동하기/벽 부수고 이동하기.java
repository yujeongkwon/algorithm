import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    static int n,m;
    static int[][] map;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        
        for(int i=0; i<n; i++){
            String input = br.readLine();
            map[i] = input.chars().map(c -> c-'0').toArray();
        }
        
        System.out.print(bfs(0,0));
        
    }
    
    public static int bfs(int i, int j) {
        int[] dx = new int[]{1,-1,0,0};
        int[] dy = new int[]{0,0,1,-1};
        int[][][] visited = new int[n][m][2];
        
        int cnt = 0;
        LinkedList<int[]> q = new LinkedList<>();
        q.push(new int[]{i,j,0});
        visited[i][j][0] = 1;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
           
            for(int idx=0; idx<4; idx++) {
                int nx = cur[0] + dx[idx];
                int ny = cur[1] + dy[idx];
                
                if(!isPossible(nx,ny)) continue;
                
                if(map[nx][ny] == 0 && visited[nx][ny][cur[2]]==0) {
                    q.offer(new int[]{nx,ny,cur[2]});
                    visited[nx][ny][cur[2]] = visited[cur[0]][cur[1]][cur[2]]+1;
                }
                if(map[nx][ny] == 1 && cur[2] == 0 && visited[nx][ny][1]==0) {
                    q.offer(new int[]{nx,ny,1});
                    visited[nx][ny][1] = visited[cur[0]][cur[1]][cur[2]]+1;
                }
            }
        }
        
    int res0 = visited[n-1][m-1][0];
    int res1 = visited[n-1][m-1][1];

    if(res0 == 0 && res1 == 0) return -1; // 도착 불가
    else if(res0 == 0) return res1;
    else if(res1 == 0) return res0;
    else return Math.min(res0, res1);

    }
    
    public static boolean isPossible(int x, int y){
        if (x>=0 && y>=0 && x<n && y<m) {
            return true;
        }
        return false;
    }
}
