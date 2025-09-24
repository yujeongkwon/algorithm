import java.io.*;
import java.util.*;
import java.util.regex.*;
import java.util.stream.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());

        List<String> numbers = new ArrayList<>();

        for(long i=0; i<N; i++) {
            String input = br.readLine();

            Pattern p = Pattern.compile("\\d+");
            Matcher m = p.matcher(input);
            while(m.find()) {
                String n = m.group().replaceFirst("^0+","");
                if(n.isEmpty())    n="0";
                numbers.add(n);
            }

        }

        numbers.sort((a,b) -> {
                     if(a.length() != b.length())    return a.length() - b.length();
                     return a.compareTo(b);
        });
        
        for(String num : numbers) {
            System.out.println(num);
        }
    }
}
