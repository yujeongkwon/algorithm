import java.io.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String input = br.readLine();
        
        String result = input.replaceAll("(c=|c-|dz=|d-|lj|nj|s=|z=)","!");
       
        System.out.print(result.length());
    }
}
