import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for(int t=0; t<T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[][] field = new int[N][M];
            int x,y;
            for(int k=0; k<K; k++) {
                st = new StringTokenizer(br.readLine());
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                field[y][x] = 1;
            }
            
            int result = 0;
            for(int i=0; i<N; i++) {
                for(int j=0; j<M; j++) {
                    if(field[i][j] == 1)    {
                        bfs(field, i, j, N, M);
                        result++;
                    }
                }
            }
            
            System.out.println(result);
        }
    }
    
    public static void bfs(int[][] field, int i, int j, int N, int M) {
        field[i][j] = 0;
        LinkedList<int[]> q = new LinkedList<>();
        q.add(new int[]{i,j});
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            for(int k=0; k<4; k++){
                int nx = cur[0]+dx[k], ny = cur[1]+dy[k];
                if(nx < 0 || ny<0 || nx >= N || ny >= M )
                    continue;
                
                if(field[nx][ny] == 1) {
                    q.add(new int[]{nx,ny});
                    field[nx][ny] = 0;
                }
            }
        }
    }
    
}
