import java.io.*;  
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int cnt = 0;
        int student[][] = new int[6][2];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int sex = Integer.parseInt(st.nextToken());
            int grade = Integer.parseInt(st.nextToken()) -1;
            if(++student[grade][sex] == K){
                cnt++;
                student[grade][sex] = 0;
            }
        }
        
        cnt += Arrays.stream(student).flatMapToInt(Arrays::stream).map(i->(i>0 ? 1 : 0)).sum();
        

        System.out.println(cnt);
    }

}
