import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long answer = 0;
        LinkedList<Long[]> stack = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            long cur = Long.parseLong(br.readLine());
            while(!stack.isEmpty() && stack.peek()[0] < cur) {
                answer+= stack.pop()[1];
            }
            
            if(!stack.isEmpty() && stack.peek()[0] == cur) {
                Long[] same = stack.pop();
                if(!stack.isEmpty()) {
                    answer++;
                }
                answer+=same[1];
                stack.push(new Long[]{cur,same[1]+1});
            }
            else {
                if(!stack.isEmpty()) {
                    answer++;
                }
                stack.push(new Long[]{cur,Long.valueOf(1)});
            }
        }
        
        System.out.print(answer);
        
        
    }
}
