import java.io.*;

public class Main {
   
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = getPrifixOfPalendrome(br.readLine());
        
        while(str.length()>1) {
            if(str.equals("-1")) {
                System.out.print("IPSELENTI");
                return ;
            }
            str = getPrifixOfPalendrome(str);
        }
        
        
        System.out.print("AKARAKA");
    }
    
    static String getPrifixOfPalendrome(String str) {
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<str.length()/2; i++) {
        
            if(str.charAt(i) != str.charAt(str.length()-1-i)) {
                return "-1";
            }
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }
}
