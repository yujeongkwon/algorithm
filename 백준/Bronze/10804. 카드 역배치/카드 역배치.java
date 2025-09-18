import java.util.*;
import java.util.stream.*;

public class Main {
    static int card[] = IntStream.rangeClosed(0,20).toArray();
    
    public static void swap(int st, int end){
        int subReserved[] = IntStream.range(0,end-st+1).map(i->card[end-i]).toArray();
        for(int i=st, s =0; i<=end; i++, s++) {
            card[i] = subReserved[s];
        }
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        for(int i=0; i<10; i++){
            int st = in.nextInt();
            int end = in.nextInt();
            swap(st,end);
        }
        
        for(int i=1; i<=20; i++){
            System.out.print(card[i] + " ");
        }
        
    }
}