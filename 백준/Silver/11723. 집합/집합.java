import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    static char[] alpa = new char[26];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        
        StringBuffer sb= new StringBuffer();
        int bit = 0;
        int x;
        for(int i=0; i<M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String comand = st.nextToken();
            
            if(comand.equals("add")){
                bit |= (1 << Integer.parseInt(st.nextToken()));
            }
            if(comand.equals("remove")){
                bit &= ~(1 << Integer.parseInt(st.nextToken()));
            }
            if(comand.equals("check")){
                sb.append((bit & (1 <<Integer.parseInt(st.nextToken()))) !=0 ? 1 : 0).append("\n");
            }
            if(comand.equals("toggle")){
                bit ^= (1 << Integer.parseInt(st.nextToken()));
            }
            if(comand.equals("all")){
                bit = (1<<21) -1 ;
            }
            if(comand.equals("empty")){
                bit = 0;
            }
        }
        System.out.print(sb.toString());
    }
}
