import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static char[][][] map = {
            {{'#','#','#'},
                    {'#','.','#'},
                    {'#','.','#'},
                    {'#','.','#'},
                    {'#','#','#'}},

            {{'#','#','#'},
                    {'.','.','#'},
                    {'#','#','#'},
                    {'#','.','.'},
                    {'#','#','#'}},   // 2

            {{'#','#','#'},
                    {'.','.','#'},
                    {'#','#','#'},
                    {'.','.','#'},
                    {'#','#','#'}},   // 3

            {{'#','.','#'},
                    {'#','.','#'},
                    {'#','#','#'},
                    {'.','.','#'},
                    {'.','.','#'}},   // 4

            {{'#','#','#'},
                    {'#','.','.'},
                    {'#','#','#'},
                    {'.','.','#'},
                    {'#','#','#'}},   // 5

            {{'#','#','#'},
                    {'#','.','.'},
                    {'#','#','#'},
                    {'#','.','#'},
                    {'#','#','#'}},   // 6

            {{'#','#','#'},
                    {'.','.','#'},
                    {'.','.','#'},
                    {'.','.','#'},
                    {'.','.','#'}},   // 7

            {{'#','#','#'},
                    {'#','.','#'},
                    {'#','#','#'},
                    {'#','.','#'},
                    {'#','#','#'}},   // 8

            {{'#','#','#'},
                    {'#','.','#'},
                    {'#','#','#'},
                    {'.','.','#'},
                    {'#','#','#'}}    // 9
    };

    static String signal;
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        signal = br.readLine();

        StringBuilder sb = new StringBuilder();

        int width = N / 5;  // 열 개수
        for (int col = 0; col < width;) {
            if (signal.charAt(col) == '.') { // 공백 열은 건너뛰기
                col++;
                continue;
            }
            int num = findNumber(col, width);
            sb.append(num);
            if (num == 1) col += 1;
            else col += 3;
        }

        System.out.println(sb.toString());
    }

    public static int findNumber(int st, int width) {
        for (int num = 0; num < 9; num++) {
            boolean ok = true;
            for (int row = 0; row < 5; row++) {
                for (int col = 0; col < 3; col++) {
                    int idx = row * width + st + col;
                    if (st + col >= width) { ok = false; break; }
                    if (map[num][row][col] != signal.charAt(idx)) { ok = false; break; }

                }
                if (!ok) break;
            }
            if (ok) return num==0 ? num : num+ 1;
        }
        return 1; // fallback
    }

}
