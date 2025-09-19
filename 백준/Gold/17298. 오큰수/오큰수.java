import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] answer =  new int[N]; 
        LinkedList<int[]> stack = new LinkedList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int cur = Integer.parseInt(st.nextToken());
            while(!stack.isEmpty() && stack.peek()[0]< cur) {
                int[] out = stack.pop();
                answer[out[1]] = cur;
            }
            stack.push(new int[]{cur,i});
        }
        while(!stack.isEmpty()) {
            answer[stack.pop()[1]] = -1;
        }
        
        String s = Arrays.stream(answer)
            .mapToObj(String::valueOf)
            .collect(Collectors.joining(" "));
        System.out.print(s);
    }
}
