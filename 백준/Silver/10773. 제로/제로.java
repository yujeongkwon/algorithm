import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        LinkedList<Integer> stack = new LinkedList<>();
        
        for(int i=0; i<K; i++){
            int n = Integer.parseInt(br.readLine());
            if(n==0) {
                stack.pop();
            }
            else {
                stack.push(n);
            }
        }
        
        System.out.print(stack.stream().mapToInt(Integer::intValue).sum());
    }
}
