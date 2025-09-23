import java.io.*;
import java.util.*;

public class Main {
    
    static int N;
    static int[][] paper;
    static int[] paperTypes = new int[3];
    
    public static void cutPaper(int n, int x, int y) {
        int first = paper[x][y];
        for(int i=x; i<x+n; i++) {
            for(int j=y; j<y+n; j++) {
                if (first != paper[i][j]) {
                    int size = n/3;
                    cutPaper(size, x, y);
                    cutPaper(size, x, y+size);
                    cutPaper(size, x, y+size*2);
                    cutPaper(size, x+size, y);
                    cutPaper(size, x+size, y+size);
                    cutPaper(size, x+size, y+size*2);
                    cutPaper(size, x+size*2, y);
                    cutPaper(size, x+size*2, y+size);
                    cutPaper(size, x+size*2, y+size*2);
                    return ;
                }
            }
        }
        paperTypes[first+1]++;
        return ;
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        paper = new int[N][N];
        
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        cutPaper(N,0,0);
        
        System.out.println(paperTypes[0]);
        System.out.println(paperTypes[1]);
        System.out.println(paperTypes[2]);
    }
}
