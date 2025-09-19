import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        LinkedList<Integer> stack = new LinkedList<>();
        
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if(command.equals("push")) {
                stack.push(Integer.parseInt(st.nextToken()));
            }
            if(command.equals("top")) {
                if(stack.peek() == null) {
                    System.out.println(-1);
                }
                else {
                    System.out.println(stack.peek());
                }
            }
            if(command.equals("size")) {
                System.out.println(stack.size());
            }
            if(command.equals("empty")) {
                if(stack.isEmpty()) {
                    System.out.println(1);
                }
                else {
                    System.out.println(0);
                }
            }
            if(command.equals("pop")) {
                if(stack.isEmpty()) {
                    System.out.println(-1);
                }
                else {
                    System.out.println(stack.pop());
                }
            }
        }
    }
}
