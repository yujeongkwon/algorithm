import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        LinkedList<Integer> stack = new LinkedList<>();
        int[] answer = new int[N];

        int[] nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=N-1; i>=0; i--) {

            while(!stack.isEmpty() && stack.peek()<= nums[i]){
                stack.pop();
            }
            if(stack.isEmpty()) {
                answer[i] = -1;
            }
            else {
                answer[i] = stack.peek();
            }
            stack.push(nums[i]);

        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(answer[i]).append(' ');
        }
        System.out.println(sb.toString());
    }
}
