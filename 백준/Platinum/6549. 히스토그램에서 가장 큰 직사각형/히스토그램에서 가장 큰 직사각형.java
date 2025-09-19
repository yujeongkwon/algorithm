import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        while(!input.equals("0")) {
            StringTokenizer st = new StringTokenizer(input);
            int n = Integer.parseInt(st.nextToken());
            long answer = 0;
            LinkedList<long[]> stack = new LinkedList<>();
            for(int i=0; i<n; i++) {
                long start = i;
                long cur = Integer.parseInt(st.nextToken());
                while(!stack.isEmpty() && stack.peek()[0] > cur) {
                    long[] top = stack.pop();
                    answer = Math.max(answer, top[0]*(i-top[1]));
                    start = top[1];
                }
                if(!stack.isEmpty() && stack.peek()[0] == cur) {
                    start = stack.pop()[1];
                }
                
                stack.push(new long[]{cur,start});
            }
            
            while(!stack.isEmpty()) {
                long[] top = stack.pop();
                answer = Math.max(answer, top[0]*(n-top[1]));
            }
            System.out.println(answer);
            input = br.readLine();
        }
    }
}
