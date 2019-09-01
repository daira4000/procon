import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
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
        C solver = new C();
        solver.solve(1, in, out);
        out.close();
    }

    static class C {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int N = in.nextInt();
            int[] H = new int[N + 1];
            for (int i = 0; i < N; i++) {
                H[i] = in.nextInt();
            }
            H[N] = Integer.MAX_VALUE;
            int max = 0;
            int cur = 0;
            for (int i = 0; i < N; i++) {
                if (H[i] >= H[i + 1]) {
                    cur++;
                } else {
                    max = Math.max(max, cur);
                    cur = 0;
                }
            }
            out.println(max);
        }

    }
}

