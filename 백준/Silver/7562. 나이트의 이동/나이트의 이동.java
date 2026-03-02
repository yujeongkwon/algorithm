import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    static int[] dx = {-1,-2,-2,-1, 1, 2, 2, 1};
    static int[] dy = {-2,-1, 1, 2,-2,-1, 1, 2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int x, y;
        for(int t=0; t<T; t++){
            int I = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            int[] start = new int[]{x,y};

            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            int[] end = new int[]{x,y};

            System.out.println(bfs(start, end, I));
        }
    }

    public static int bfs(int[] start, int[] end, int I) {
        int[][] visited = new int[I][I];
        LinkedList<int[]> q = new LinkedList<>();
        q.add(start);

        while(!q.isEmpty()) {
            int[] cur = q.poll();

            if(cur[0]==end[0] && cur[1]==end[1])
                return visited[cur[0]][cur[1]];

            for(int k=0; k<8; k++){
                int nx = cur[0]+dx[k], ny = cur[1]+dy[k];
                if(nx < 0 || ny<0 || nx >= I || ny >= I )
                    continue;


                if(visited[nx][ny] == 0) {
                    q.add(new int[]{nx,ny});
                    visited[nx][ny] = visited[cur[0]][cur[1]]+ 1;
                }

            }
        }




        return 0;
    }

}
