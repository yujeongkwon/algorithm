import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        
        int arr[] = new int[3];
        for (int i = 0; i<3; i++) {
            arr[i] = in.nextInt();
        }
        
        in.close();
        
        Arrays.sort(arr);
        for (int i = 0; i<3; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}