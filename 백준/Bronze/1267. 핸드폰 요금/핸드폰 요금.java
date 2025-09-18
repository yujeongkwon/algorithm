import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int N = in.nextInt();
        int cur = 0;
        int Y = 0;
        int M = 0;
        for(int i=0; i<N; i++){
            cur = in.nextInt();
            Y += (cur/30 + 1) * 10;
            M += (cur/60 + 1) * 15;
        }
        
        if (Y < M) {
            System.out.println("Y " + Y);
        } else if (Y > M) {
            System.out.println("M " + M);
        } else {
            System.out.println("Y M " + Y);
        }

    }
}