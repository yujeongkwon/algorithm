import java.io.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] pattern = br.readLine().split("\\*");
        
        for(int i=0; i<n; i++) {
            String name = br.readLine();
            boolean sw = name.startsWith(pattern[0]);
            boolean es = name.endsWith(pattern[1]);
            if(sw && es && pattern[0].length()+pattern[1].length()<= name.length()) {
                System.out.println("DA");
            }
            else
            {
                System.out.println("NE");
            }
        }
       
    }
}
