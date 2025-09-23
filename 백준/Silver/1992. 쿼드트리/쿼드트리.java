import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    
    static int N;
    static int[][] video;
    static StringBuilder sb = new StringBuilder();
    
    public static void compressVideo(int n, int x, int y) {
        int first = video[x][y];
        
        for(int i=x; i<x+n; i++) {
            for(int j=y; j<y+n; j++) {
                if (first != video[i][j]) {
                    int size = n/2;
                    
                    sb.append("(");
                    compressVideo(size, x, y);
                    compressVideo(size, x, y+size);
                    compressVideo(size, x+size, y);
                    compressVideo(size, x+size, y+size);
                    sb.append(")");
                    return ;
                }
            }
        }
        sb.append(first);
        return ;
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        video = new int[N][N];
        
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            video[i] = st.nextToken().chars().map(c->c-'0').toArray();
        }
        
        compressVideo(N,0,0);
        System.out.print(sb.toString());
    }
}
