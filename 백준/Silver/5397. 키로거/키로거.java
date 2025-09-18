import java.io.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());

        for (int t = 0; t < L; t++) {
            String pwd = br.readLine();

            // 커서 왼쪽/오른쪽
            LinkedList<Character> front = new LinkedList<>();
            LinkedList<Character> back  = new LinkedList<>();

            for (char c : pwd.toCharArray()) {
                if (c == '<') {                          // 왼쪽 이동
                    if (!front.isEmpty()) back.addFirst(front.removeLast());
                } else if (c == '>') {                   // 오른쪽 이동
                    if (!back.isEmpty()) front.addLast(back.removeFirst());
                } else if (c == '-') {                   // 백스페이스
                    if (!front.isEmpty()) front.removeLast();
                } else {                                  // 일반 문자
                    front.addLast(c);
                }
            }

            // 결과 = front + back(그대로; back의 앞이 커서 바로 오른쪽)
            front.addAll(back);
            System.out.println(front.stream().map(String::valueOf).collect(Collectors.joining()));
        }
    }
}
