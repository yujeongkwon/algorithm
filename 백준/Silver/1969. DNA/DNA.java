import java.io.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        String[] dna = new String[N];
        int[][] cnt = new int[M][4];
        for(int i=0; i<N; i++) {
            dna[i] = br.readLine();
            for(int j=0; j<M; j++) {
                if(dna[i].charAt(j)=='A') {
                    cnt[j][0]++;
                }
                if(dna[i].charAt(j)=='C') {
                    cnt[j][1]++;
                }
                if(dna[i].charAt(j)=='G') {
                    cnt[j][2]++;
                }
                if(dna[i].charAt(j)=='T') {
                    cnt[j][3]++;
                }
            }
        }
        
        StringBuilder sb  = new StringBuilder();
        for(int i=0; i<M; i++) {
            int max = 0, idx = 0;
            for(int j=0; j<4; j++) {
                if(max<cnt[i][j]) {
                    max = cnt[i][j];
                    idx = j;
                }
            }
            if(idx==0) {
                sb.append('A');
            }
            if(idx==1) {
                sb.append('C');
            }
            if(idx==2) {
                sb.append('G');
            }
            if(idx==3) {
                sb.append('T');
            }
        }
        
        String dnaResult = sb.toString();
        int hd = 0;
        for(int i=0; i<N; i++) {
            int count=0;
            for(int j=0; j<M; j++) {
                if(dnaResult.charAt(j) != dna[i].charAt(j)) {
                   count++;
                }
            }
            hd += count;
        }
        System.out.println(dnaResult);
        System.out.println(hd);
    }
}
