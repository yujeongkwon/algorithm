import java.util.*;

public class Main {
    public static char play(int arr[]){
        int sum = Arrays.stream(arr).sum();
        if(sum == 1){
            return 'C';
        }
        if(sum == 2){
            return 'B';
        }
        if(sum == 3){
            return 'A';
        }
        if(sum == 4){
            return 'E';
        }
        
        return 'D';
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
           
        for(int t=0; t<3; t++) {
           int arr[] = new int[4];
           for(int i=0; i<4; i++){
               arr[i] = in.nextInt();
           }
           System.out.println(play(arr));
        }
        
        return ;
        
    }
}