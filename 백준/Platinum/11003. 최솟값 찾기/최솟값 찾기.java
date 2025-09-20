import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        StringBuilder sb = new StringBuilder();
        LinkedList<Integer> queue = new LinkedList<>(); 
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            while(!queue.isEmpty() && arr[i] < arr[queue.getLast()]) {
                queue.pollLast();
            }
            queue.offerLast(i);
            while(!queue.isEmpty() && i>=L && queue.getFirst() < i-L+1) {
                queue.pollFirst();
            }
            
            sb.append(arr[queue.getFirst()]).append(" ");
        }
        
        System.out.print(sb.toString().strip());

        
    }
}
