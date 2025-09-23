import java.io.*;
import java.util.*;

public class Main {
    
    static int N,r,c;
    
    public static int getZ(int n, int x, int y) {
        if(n==0)    return 0;
        
        int half = 1 << (n-1);
        int size = half * half;
        if(x<half && y<half) return getZ(n-1, x, y);
        if(x<half && y>=half) return size + getZ(n-1, x, y-half);
        if(x>=half && y<half) return size*2 + getZ(n-1, x-half, y);
        return size*3 + getZ(n-1, x-half, y-half);
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
       
        System.out.print(getZ(N, r, c));
    }
}
