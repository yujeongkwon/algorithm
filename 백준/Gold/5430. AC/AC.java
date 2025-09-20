import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for(int t=0; t<T; t++) {
            String command = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String arr = br.readLine().replaceAll("[\\[\\]\\s]","");
            LinkedList<Integer> queue = arr.isEmpty() 
                ? new LinkedList<>()
                : Arrays.stream(arr.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(LinkedList::new));
            
            int flag= 1,end = 0;
            for(char c: command.toCharArray()) {
                if(c=='R') {
                    flag*=-1;
                }
                if(c=='D') {
                    if(!queue.isEmpty()){
                        if(flag==1) queue.pollFirst();
                        else        queue.pollLast();
                    }
                    else {
                        System.out.println("error");
                        end=1;
                        break;
                    }
                }
            }
            
            if(flag==-1) {
                Collections.reverse(queue);
            }
            if(end==0){
                System.out.println(queue.stream().map(String::valueOf).collect(Collectors.joining(",","[","]")));
            }
        }
    }
}
