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
        D solver = new D();
        solver.solve(1, in, out);
        out.close();
    }

    static class D {
        long[] a;
        long[] p;

        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int N = in.nextInt();
            long X = in.nextLong();
            a = new long[N + 1];
            p = new long[N + 1];
            a[0] = p[0] = 1;
            for (int i = 1; i <= N; i++) {
                a[i] = a[i - 1] * 2 + 3;
                p[i] = p[i - 1] * 2 + 1;
            }

            long count = calc(N, X);
            out.println(count);
        }

        private long calc(int N, long X) {
            if (X <= 1) {
                return N == 0 ? 1 : 0;
            } else if (X < 2 + a[N - 1]) {
                return calc(N - 1, X - 1);
            } else if (X == 2 + a[N - 1]) {
                return p[N - 1] + 1;
            } else if (X < 3 + 2 * a[N - 1]) {
                return p[N - 1] + 1 + calc(N - 1, X - 2 - a[N - 1]);
            }
            return 2 * p[N - 1] + 1;
        }

    }
}

