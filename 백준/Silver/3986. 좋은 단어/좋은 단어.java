import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int result = 0;
        for(int i=0; i<N; i++) {
            LinkedList<Character> stack = new LinkedList<>();
            String word = br.readLine();
            for(char c : word.toCharArray()) {
                if(!stack.isEmpty() && stack.peek() == c) {
                    stack.pop();
                    continue;
                }
                stack.push(c);
            }
            
            if(stack.isEmpty())    result++;
            
        }
        
        System.out.println(result);
    }
}
