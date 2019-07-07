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
        static long MOD = 2019;

        public void solve(int testNumber, Scanner in, PrintWriter out) {
            long L = in.nextLong();
            long R = in.nextLong();
            if (L == 0) {
                out.println(0);
                return;
            }

            long min = 2019;
            for (long i = L; i < Math.min(L + 9999, R); i++) {
                for (long j = i + 1; j <= Math.min(L + 9999, R); j++) {
                    min = Math.min(min, (i * j) % MOD);
                }
            }
            out.println(min);
        }

    }
}

