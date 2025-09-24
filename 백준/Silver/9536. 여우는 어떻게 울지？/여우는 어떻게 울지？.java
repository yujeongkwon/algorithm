import java.io.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++) {
            String record = br.readLine();
            String[] input = br.readLine().split("( goes )");
            while(input.length == 2) {
               record = record.replaceAll("\\b"+input[1]+ "\\b", "");
                
                input = br.readLine().split("( goes )");
           } 
           record = record.replaceAll("\\s+", " ");
           System.out.println(record.strip());
        }
    }
}
