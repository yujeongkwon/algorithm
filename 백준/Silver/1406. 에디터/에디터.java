import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String string = br.readLine();

        LinkedList<Character> front = string.chars()
            .mapToObj(c -> (char) c)
            .collect(Collectors.toCollection(LinkedList::new));
        LinkedList<Character> back = new LinkedList<>();
        
        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char command = st.nextToken().charAt(0);

            if (command == 'P') {
                char ch = st.nextToken().charAt(0);
                front.add(ch);
            } else if (command == 'L' && !front.isEmpty()) {
                back.addFirst(front.removeLast());
            } else if (command == 'D' && !back.isEmpty()) {
                front.add(back.removeFirst());
            } else if (command == 'B' && !front.isEmpty()) {
                front.removeLast();
            }
        }
        
        front.addAll(back);
        System.out.print(
            front.stream()
               .map(String::valueOf)
               .collect(Collectors.joining())
        );
    }
}
