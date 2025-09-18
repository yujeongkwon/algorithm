import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
           
        int arr[] = new int[9];
        for(int i=0; i<9; i++){
            arr[i] = in.nextInt();
        }
        
        int sum = Arrays.stream(arr).sum();
        int result[] = new int[7];
        for(int i=0; i<9; i++) {
            for(int j=i+1; j<9; j++) {
                if(sum-arr[i]-arr[j] == 100) {
                    int r=0;
                    for(int k=0; k<9; k++) {
                        if(k!= i && k!=j){
                            result[r++] = arr[k];
                        }
                    }
                    break;
                }
            }
        }
        
        Arrays.sort(result);
        for(int i =0; i<7; i++) {
            System.out.println(result[i]);
        }
        return ;
        
    }
}