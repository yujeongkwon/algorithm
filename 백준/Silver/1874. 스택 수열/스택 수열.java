import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] inputWaterHeat = new int[n];
        for (int i = 0; i < n; i++) {
            inputWaterHeat[i] = sc.nextInt();
        }

        Stack<Integer> stack = new Stack<>();
        StringBuffer bf = new StringBuffer();
        int inputPeak = 0;
        int i = 1;

        while (i <= n || !stack.isEmpty()) {
            if (!stack.isEmpty() && stack.peek() == inputWaterHeat[inputPeak]) {
                stack.pop();
                inputPeak++;
                bf.append("-\n");
            } else if (i <= n) {
                stack.push(i);
                i++;
                bf.append("+\n");
            } else {
                System.out.print("NO");
                return;
            }
        }

        System.out.print(bf.toString());
    }
}
