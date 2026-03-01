import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int result = 0;
        LinkedList<Integer> nums = new LinkedList<>(IntStream.rangeClosed(1,N)
                                                    .boxed()
                                                   .collect(Collectors.toList()));
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) {
            int want =  Integer.parseInt(st.nextToken());
            
            int idx = nums.indexOf(want);
            if(idx <= nums.size() - idx) {
                result += idx;
                for(int j=0; j<idx; j++)    nums.offer(nums.poll());
                nums.poll();
            }
            else {
                result += (nums.size() - idx);
                for(int j=0; j<nums.size() - idx; j++)    nums.offerFirst(nums.pollLast());
                nums.poll();
            }
        }
        
        System.out.print(result);
    }
}
