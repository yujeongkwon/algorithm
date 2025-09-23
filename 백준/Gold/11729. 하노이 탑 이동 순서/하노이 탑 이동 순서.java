import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static StringBuilder sb= new StringBuilder();
    
    public static int hanoi(int n, int st, int sp, int end) {
        if(n==1) {
            sb.append(st).append(" ").append(end).append("\n");
            return 1;
        }
        if(n==2) {
            sb.append(st).append(" ").append(sp).append("\n");
            sb.append(st).append(" ").append(end).append("\n");
            sb.append(sp).append(" ").append(end).append("\n");
            return 3;
        }
        
        int cnt = hanoi(n-1, st, end, sp);
        sb.append(st).append(" ").append(end).append("\n");
        cnt++;
        cnt += hanoi(n-1, sp, st, end);
        return cnt;
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int cnt = hanoi(N, 1, 2, 3);
        
        sb.insert(0, cnt + "\n");

        System.out.print(sb.toString());
    }
}
