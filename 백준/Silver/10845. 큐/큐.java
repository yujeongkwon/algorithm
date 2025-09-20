import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        LinkedList<Integer> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String input = st.nextToken();
            if(input.equals("push")){
                queue.offer(Integer.parseInt(st.nextToken()));
            }
            if(input.equals("pop")) {
                if(!queue.isEmpty()){
                    sb.append(queue.poll()).append("\n");
                }
                else{
                    sb.append("-1\n");
                }
            }
            if(input.equals("size")){
                sb.append(queue.size()).append("\n");
            }
            if(input.equals("empty")) {
                if(!queue.isEmpty()){
                    sb.append("0\n");
                }
                else{
                    sb.append("1\n");
                }
            }
            if(input.equals("back")) {
                if(!queue.isEmpty()){
                    sb.append(queue.getLast()).append("\n");
                }
                else{
                    sb.append("-1\n");
                }
            }
            if(input.equals("front")) {
                if(!queue.isEmpty()){
                    sb.append(queue.getFirst()).append("\n");
                }
                else{
                    sb.append("-1\n");
                }
            }
           
                
        }
                           
        System.out.print(sb.toString());
    }
}
