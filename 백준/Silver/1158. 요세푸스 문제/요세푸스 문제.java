import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        LinkedList<Integer> yose = IntStream.rangeClosed(1,N)
            .mapToObj(Integer::valueOf)
            .collect(Collectors.toCollection(LinkedList::new));
        
        StringBuilder sb = new StringBuilder();
        sb.append('<');
        while(!yose.isEmpty()){
            for(int i=0; i<K-1; i++) {
                yose.offer(yose.poll());
            }
            sb.append(yose.poll());
            if (!yose.isEmpty()) sb.append(", ");
        }
        sb.append('>');
        System.out.print(sb.toString());
    }
}
