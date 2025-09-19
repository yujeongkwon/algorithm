import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long answer = 0;
        LinkedList<Long> stack = new LinkedList<>();

        for (int i=0; i<N; i++){
            long cur= Long.parseLong(br.readLine());
            while(!stack.isEmpty() && stack.peek() <= cur) {
                stack.pop();
            }
            answer+= stack.size();
            stack.push(cur);
        }
        
       System.out.print(answer);
    }
}
