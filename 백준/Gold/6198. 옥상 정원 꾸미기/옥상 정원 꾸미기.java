import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long result = 0;
        
        LinkedList<Integer> stack = new LinkedList<>();
        for(int i=0; i<N; i++) {
            int cur = Integer.parseInt(br.readLine());
            while(!stack.isEmpty() && stack.peekLast() <= cur) {
                stack.pollLast();
            }
            result += stack.size();
            stack.addLast(cur);
        }
        
        System.out.print(result);
    }
}
