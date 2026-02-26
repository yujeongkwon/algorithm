import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] n = new int[3];
        
        for(int i=0; i<3; i++) {
            n[i] = Integer.valueOf(br.readLine());
        }
        
        int mul = Arrays.stream(n).reduce(1, (a, b) -> a * b);
        
        int count[] = new int[10];
        while(mul != 0) {
            count[mul%10]++;
            mul /= 10;
        }
        
        for(int i=0; i<10; i++){
            System.out.println(count[i]);
        }
    }

}
