import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String doc = br.readLine();
        String seek = br.readLine();
        
        doc = doc.replace(seek,"!");
        int cnt = 0;
        for(char c : doc.toCharArray()) {
            if(c=='!') {
                cnt++;
            }
        }
        System.out.print(cnt);
    }
}
