import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = new int[10];
        int N = Integer.parseInt(br.readLine());
        
        while(N!=0) {
            int number = N%10;
            if(number == 6 || number == 9) {
                if(numbers[6] < numbers[9]){ 
                    number = 6;
                }
                else {
                    number = 9;
                }
            }
            numbers[number]++;
            N/=10;
        }
        
        System.out.println(Arrays.stream(numbers).max().getAsInt());
    }

}
