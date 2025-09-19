import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        LinkedList<Integer> stack = new LinkedList<>();
        
        int cnt = 1;
        
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++){
            int input = Integer.parseInt(br.readLine());
            while(cnt <= input) {
                stack.push(cnt++);
                sb.append("+\n");
            }
            
            if(stack.isEmpty() || stack.peek() != input){
                System.out.print("NO");
                return ;
            }
            
            stack.pop();
            sb.append("-\n");
        }
        
        System.out.print(sb.toString());
    }
}
