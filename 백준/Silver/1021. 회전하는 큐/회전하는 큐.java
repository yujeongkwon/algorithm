import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        LinkedList<Integer> queue = IntStream.rangeClosed(1,N)
            .boxed()
            .collect(Collectors.toCollection(LinkedList::new));
        
        st = new StringTokenizer(br.readLine());
        int answer = 0;
        for(int i=0; i<M; i++) {
            int seek = Integer.parseInt(st.nextToken());
            int left = queue.indexOf(seek);
            int right = queue.size()-left;
            
            if(left<=right){
                answer+=left;
                for(int l=0; l<left; l++) {
                    queue.offer(queue.poll());
                }
                
            }
            else {
                answer+=right;
                for(int r=0; r<right; r++) {
                    queue.offerFirst(queue.pollLast());
                }
               
            }
            queue.poll();
        }
                           
        System.out.print(answer);
    }
}
