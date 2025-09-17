import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int number[] = new int[10];
        for (int i = 0; i<3; i++) {
            number[in.nextInt()]++;
        }
        
        in.close();
        
        int max = 0;
        for (int i = 1; i<10; i++) {
            if(number[max]<= number[i]) {
                max = i;
            }
        }
        if (number[max] == 3) {
            System.out.print(10000+max*1000);
            return ;
        }
        if (number[max] == 2) {
            System.out.print(1000+max*100);
            return ;
        }
        if (number[max] == 1) {
            System.out.print(max*100);
            return ;
        }
    }
}