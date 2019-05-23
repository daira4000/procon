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
        C solver = new C();
        solver.solve(1, in, out);
        out.close();
    }

    static class C {
        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int N = in.nextInt();
            int[] h = new int[N + 1];
            Arrays.fill(h, 0);
            for (int i = 0; i < N; i++) {
                h[i] = in.nextInt();
            }

            int count = 0;
            for (int i = 0; i < N; i++) {
                if (h[i] > h[i + 1]) {
                    count += h[i] - h[i + 1];
                }
            }
            out.println(count);
        }

    }
}

