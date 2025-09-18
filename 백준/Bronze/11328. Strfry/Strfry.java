import java.io.*;  
import java.util.*;

public class Main {
    public static Boolean compare(String origin, String strfy) {
        int alpaOrigin[] = new int[26];
        int alpaStrfy[] = new int[26];
        
        if(origin.length() != strfy.length()) {
            return false;
        }
        
        for(int i=0; i<origin.length(); i++) {
            alpaOrigin[origin.charAt(i) - 'a']++;
            alpaStrfy[strfy.charAt(i) - 'a']++;
        }
        
        for(int i=0; i<26; i++) {
            if(alpaOrigin[i] != alpaStrfy[i]) {
                return false;
            }
        }
        
        return true;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            String origin = st.nextToken();
            String strfy = st.nextToken();
            if(compare(origin, strfy)) {
                System.out.println("Possible");
            }
            else {
                System.out.println("Impossible");
            }
        }
    }

}
