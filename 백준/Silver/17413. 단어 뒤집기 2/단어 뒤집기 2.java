import java.io.*;

public class Main {
    static String str;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        str = br.readLine();
        
        StringBuffer result = new StringBuffer();
        StringBuffer word = new StringBuffer();
        boolean tagFlag = false;
        for(int i=0; i<str.length(); i++) {
            char c = str.charAt(i);
            if(c == '<') {
                result.append(word.reverse());
                word.setLength(0);
                result.append(c);
                tagFlag = true;
            }
            else if(c=='>'){
                tagFlag = false;
                result.append(c);
                word.setLength(0);
            }
            else if(!tagFlag && c==' ') {
                result.append(word.reverse());
                result.append(c);
                word.setLength(0);
            }
            else if(tagFlag) {
                result.append(c);
            }
            else {
                word.append(c);
            }
        }
     result.append(word.reverse());   
     System.out.print(result.toString());
        
    }
}
