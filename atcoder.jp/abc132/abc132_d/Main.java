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
        static final int MOD = (int) 1e9 + 7;
        private static int MAX = 400000;
        private static long[] xs = new long[MAX + 1];
        private static long[] ys = new long[MAX + 1];

        public void solve(int testNumber, Scanner in, PrintWriter out) {
            int N = in.nextInt();
            int K = in.nextInt();

            for (int i = 1; i <= K; i++) {
                long ans = comb(N - K + 1, i) * comb(K - 1, i - 1) % MOD;
                out.println(ans);
            }
        }

        private long comb(int n, int r) {
            if (r < 0 || r > n) return 0;
            if (xs[0] == 0) {
                xs[0] = 1;
                for (int i = 1; i <= MAX; i++) {
                    xs[i] = xs[i - 1] * i % MOD;
                }
                long inv = modpow(xs[MAX]);
                ys[MAX] = inv;
                for (int i = MAX; i >= 1; i--) {
                    inv = inv * i % MOD;
                    ys[i - 1] = inv;
                }
            }
            return xs[n] * (ys[r] * ys[n - r] % MOD) % MOD;
        }

        private long modpow(long a) {
            return modpow(a, MOD - 2);
        }

        private long modpow(long a, long n) {
            long r = 1;
            while (n > 0) {
                r = r * ((n % 2) != 0 ? a : 1) % MOD;
                a = a * a % MOD;
                n >>= 1;
            }
            return r;
        }

    }
}

