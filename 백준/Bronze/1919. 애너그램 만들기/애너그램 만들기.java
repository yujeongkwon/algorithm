import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word1 = br.readLine();
        String word2 = br.readLine();

        HashMap<Character, Integer> firstWords = new HashMap<>();
        for(Character c : word1.toCharArray()) {
            if(firstWords.containsKey(c)) {
                firstWords.put(c,firstWords.get(c)+1);
            }
            else {
                firstWords.put(c, 1);
            }
        }

        HashMap<Character, Integer> secondWords = new HashMap<>();
        for(Character c : word2.toCharArray()) {
            if(secondWords.containsKey(c)) {
                secondWords.put(c,secondWords.get(c)+1);
            }
            else {
                secondWords.put(c, 1);
            }
        }

        int answer = 0;
        HashSet<Character> union = new HashSet<>(firstWords.keySet());
        union.addAll(secondWords.keySet());

        for (Character c : union) {
            if(firstWords.containsKey(c) && secondWords.containsKey(c)) {
                answer += Math.abs(firstWords.get(c)-secondWords.get(c));
            }
            else if (firstWords.containsKey(c)) {
                answer += firstWords.get(c);
            }
            else if (secondWords.containsKey(c)) {
                answer += secondWords.get(c);
            }
        }

        System.out.println(answer);
    }
}
