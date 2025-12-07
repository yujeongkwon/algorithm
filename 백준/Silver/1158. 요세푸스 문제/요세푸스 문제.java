import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        LinkedList<Integer> list = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        sb.append('<');
        for(int i=1; i<=N; i++) {
            list.offer(i);
        }

        int k =K;
        while(!list.isEmpty()) {
            if(k==1) {
                sb.append(list.poll());
                sb.append(", ");
                k=K;
            }
            else {
                list.offer(list.poll());
                k--;
            }
        }
        sb.delete(sb.length()-2, sb.length());
        sb.append('>');
        System.out.print(sb.toString());
    }
}
