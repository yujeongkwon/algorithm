import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        int[] numbers = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++){
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int x = Integer.valueOf(br.readLine());
        int answer = 0;

        Arrays.sort(numbers);
        int lf = 0, rt = n-1;
        while(lf<rt) {
            if(numbers[lf] + numbers[rt] == x) {
                answer++;
                numbers[lf] = -1;
                numbers[rt] = -1;
                lf++;
                rt--;
            }
            else if(numbers[lf] + numbers[rt] > x) {
                rt--;
            }
            else if(numbers[lf] + numbers[rt] < x) {
                lf++;
            }
        }

        System.out.println(answer);
    }

}
