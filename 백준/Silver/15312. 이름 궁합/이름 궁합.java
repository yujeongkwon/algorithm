import java.io.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

public class Main {
    
    static int[] stroke = new int[]{3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String jong = br.readLine();
        String her = br.readLine();

        int N = jong.length();
        int[] score = new int[N*2];

        for (int i=0; i<N; i++) {
            score[2*i]   = stroke[jong.charAt(i) - 'A'];
            score[2*i+1] = stroke[her.charAt(i) - 'A'];
        }

        for(int i=score.length-1; i>1; i--){
            for(int j=0; j<i; j++) {
                score[j] = (score[j] + score[j+1])%10;
            }

        }
        System.out.println(Integer.toString(score[0])+Integer.toString(score[1]));
    }
}
