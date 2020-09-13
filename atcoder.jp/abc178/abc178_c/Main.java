import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;

/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 */
public class Main {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        MyScanner in = new MyScanner(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        C solver = new C();
        solver.solve(1, in, out);
        out.close();
    }

    static class C {
        int N;
        static long MOD = (long) (1e9 + 7);
        private static int MAX = 1000001;
        private static long[] xs = new long[MAX + 1];
        private static long[] ys = new long[MAX + 1];

        public void solve(int testNumber, MyScanner in, PrintWriter out) {
            N = in.Int();
            if (N == 1) {
                out.println(0);
                return;
            }

            long ans = 0;
            for (int i = 2; i <= N; i++) {
                long a = modpow(2, i) - 2;
                long b = modpow(8, N - i);
                long c = comb(N, i);
                ans += (((a * b) % MOD) * c) % MOD;
                ans %= MOD;
            }
            out.println(ans);
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

    static class MyScanner {
        private BufferedReader in;
        private StringTokenizer st;

        public MyScanner(InputStream stream) {
            in = new BufferedReader(new InputStreamReader(stream));
        }

        public String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    String rl = in.readLine();
                    if (rl == null) {
                        return null;
                    }
                    st = new StringTokenizer(rl);
                } catch (IOException e) {
                    return null;
                }
            }
            return st.nextToken();
        }

        public int Int() {
            return Integer.parseInt(next());
        }

    }
}

