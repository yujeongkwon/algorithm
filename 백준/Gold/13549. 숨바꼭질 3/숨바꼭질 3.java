import java.io.*;
import java.util.*;

public class Main {
    static final int MAX = 100000;
    static final int INF = 1_000_000_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 빠른 가지치기: 뒤로만 가면 되는 경우
        if (N >= K) {
            System.out.println(N - K);
            return;
        }

        int[] dist = new int[MAX+1];
        Arrays.fill(dist, INF);
        LinkedList<Integer> q = new LinkedList<>();
        
        dist[N] = 0;
        q.offer(N);
        while(!q.isEmpty()) {
            int x = q.poll();
            if(x==K)    break;
            
            int nx = x*2;
            if(nx<= MAX && dist[nx] > dist[x]) {
                dist[nx] = dist[x];
                q.offerFirst(nx);
            }
            
            nx = x-1;
            if(nx >=0 && dist[nx] > dist[x]+1) {
                dist[nx] = dist[x] + 1;
                q.offer(nx);
            }
            
            nx = x+1;
            if(nx<= MAX && dist[nx] > dist[x]+1) {
                dist[nx] = dist[x] + 1;
                q.offer(nx);
            }
        }
        
        System.out.println(dist[K]);
    }
}
