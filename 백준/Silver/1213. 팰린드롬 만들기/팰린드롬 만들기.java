import java.io.*;

public class Main {
    static char[] alpa = new char[26];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String name = br.readLine();
        for(char c : name.toCharArray()) {
            alpa[c-'A']++;
        }
        int center = -1;
        for(int i=0; i<26; i++) {
            if(center != -1 && alpa[i]%2!=0) {
                System.out.print("I'm Sorry Hansoo");
                return;
            }
            if(center == -1 && alpa[i]%2!=0) {
                center = i;
                alpa[i]--;
            }
            alpa[i]/=2;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<26; i++) {
            while(alpa[i] !=0) {
                sb.append((char)(i+'A'));
                alpa[i]--;
            }
        }

        System.out.print(sb.toString()+(center != -1 ? (char) (center+'A') : "")+sb.reverse().toString());
    }
}
