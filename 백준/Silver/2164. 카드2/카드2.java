import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        LinkedList<Integer> queue = IntStream.rangeClosed(1,N)
            .boxed().collect(Collectors.toCollection(LinkedList::new));
        
        while(queue.size()>1){
            queue.pop();
            queue.offer(queue.pop());
        }
        
        System.out.print(queue.poll());
    }
}
