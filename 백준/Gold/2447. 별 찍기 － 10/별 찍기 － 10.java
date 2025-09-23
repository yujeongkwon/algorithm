import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    
    static int N;
    static char[][] space;

    public static void printStar(int n, int x, int y) {
        if(n==1) {
            space[x][y] = '*';
            return ;
        }

        int size = n/3;
        printStar(n/3, x, y);
        printStar(n/3, x, y+size);
        printStar(n/3, x, y+size*2);
        printStar(n/3, x+size, y);
        printStar(n/3, x+size, y+size*2);
        printStar(n/3, x+size*2, y);
        printStar(n/3, x+size*2, y+size);
        printStar(n/3, x+size*2, y+size*2);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        space = new char[N][N];
        
        for (int i = 0; i < N; i++) {
            Arrays.fill(space[i], ' ');
        }
        
        printStar(N,0,0);

        for(int i=0 ; i<N; i++){
            System.out.println(new String(space[i]));
        }
    }
}
