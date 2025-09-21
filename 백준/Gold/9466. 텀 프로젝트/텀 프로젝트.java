import java.io.*;
import java.util.*;

public class Main {
    static int[] next;         // 각 학생이 선택한 학생
    static boolean[] visited;  // 방문 여부
    static boolean[] finished; // 탐색 종료 여부
    static int circle;         // 사이클에 속한 학생 수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            next = new int[n+1];
            visited = new boolean[n+1];
            finished = new boolean[n+1];
            circle = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=1; i<=n; i++) {
                next[i] = Integer.parseInt(st.nextToken());
            }

            for(int i=1; i<=n; i++) {
                if(!visited[i]) dfs(i);
            }

            System.out.println(n - circle);
        }
    }

    static void dfs(int cur) {
        visited[cur] = true;
        int nxt = next[cur];

        if(!visited[nxt]) {
            dfs(nxt);
        } else if(!finished[nxt]) {
            // 사이클 발견
            circle++;
            for(int v=nxt; v!=cur; v=next[v]) {
                circle++;
            }
        }

        finished[cur] = true;
    }
}
