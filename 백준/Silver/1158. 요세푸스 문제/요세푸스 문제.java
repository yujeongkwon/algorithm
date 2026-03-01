import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        sb.append('<');
        
        LinkedList<Integer> list = new LinkedList<>(IntStream.rangeClosed(1,n)
                                                    .boxed()
                                                    .collect(Collectors.toList()));
        ListIterator<Integer> it = list.listIterator();
        int cur = 0;
        while(list.size() != 1) {
            if(!it.hasNext()) it = list.listIterator();
            
            int val = it.next();
            cur++;
            
            if(cur==k) {
                sb.append(val).append(", ");
                it.remove();
                cur=0;
            }
        }
        
        sb.append(list.get(0)).append('>');
        System.out.println(sb.toString());
    }

}
