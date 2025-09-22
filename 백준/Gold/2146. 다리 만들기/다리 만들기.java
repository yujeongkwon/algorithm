import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] island;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
       
        island = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                island[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // 1. 섬 구분 (2부터 색칠)
        int color = 2;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (island[i][j] == 1) {
                    printIsland(i, j, color++);
                }
            }
        }
        
        // 2. 각 섬에서 BFS로 다리 최소 길이 탐색
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (island[i][j] > 0) {
                    min = Math.min(min, findMin(i, j));
                }
            }
        }
        
        System.out.print(min);
    }
    
    public static void printIsland(int i, int j, int color) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, j});
        island[i][j] = color;
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];
                if (!isPossible(nx, ny)) continue;
                if (island[nx][ny] == 1) {
                    island[nx][ny] = color;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
    }
    
    public static int findMin(int i, int j) {
        int color = island[i][j];
        int[][] dist = new int[N][N];
        for (int k = 0; k < N; k++) Arrays.fill(dist[k], -1);

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i, j});
        dist[i][j] = 0;
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];
                if (!isPossible(nx, ny)) continue;
                
                // 다른 섬 도착
                if (island[nx][ny] != 0 && island[nx][ny] != color) {
                    return dist[cur[0]][cur[1]];
                }
                // 바다 확장
                if (island[nx][ny] == 0 && dist[nx][ny] == -1) {
                    dist[nx][ny] = dist[cur[0]][cur[1]] + 1;
                    q.offer(new int[]{nx, ny});
                }
                // 같은 섬 내부는 dist=0으로 유지
                if (island[nx][ny] == color && dist[nx][ny] == -1) {
                    dist[nx][ny] = 0;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
        return Integer.MAX_VALUE;
    }
    
    public static boolean isPossible(int x, int y) {
        return (x >= 0 && x < N && y >= 0 && y < N);
    }
}
