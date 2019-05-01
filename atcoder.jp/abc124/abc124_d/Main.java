import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Scanner in = new Scanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        D solver = new D();
        solver.solve(1, in, out);
        out.close();
    }

    static class D {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int N = in.nextInt();
            int K = in.nextInt();
            String S = in.next();

            int[] head = new int[N + 1];
            Arrays.fill(head, 0);
            int count = 1;
            for (int i = 1; i < N; i++) {
                if (S.charAt(i - 1) != S.charAt(i)) {
                    head[count++] = i;
                }
            }
            head[count] = N;

            int max = 1;
            for (int i = 0; i < count; i++) {
                boolean zero = S.charAt(head[i]) == '0';
                int last = Math.min(i + K * 2 + (zero ? 0 : 1), count);
                int sum = head[last] - head[i];
                max = Math.max(sum, max);
            }
            out.println(max);
        }

    }
}

