import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.function.BiFunction;
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
        D solver = new D();
        solver.solve(1, in, out);
        out.close();
    }

    static class D {
        static long MOD = (long) (1e9 + 7);

        public void solve(int testNumber, MyScanner in, PrintWriter out) {
            long n = in.nextInt();
            long a = in.nextInt();
            long b = in.nextInt();

            long x = modpow(2, n) - 1;
            BiFunction<Long, Long, Long> func = (Long q, Long w) -> {
                long e = 1;
                long r = 1;
                for (long i = 0; i < w; i++) {
                    e = (e * (q - i)) % MOD;
                    r = (r * (i + 1)) % MOD;
                }
                return (long) ((e * modpow(r)) % MOD);
            };
            long y = func.apply(n, a);
            long z = func.apply(n, b);
            x = (x - y - z + MOD * 2) % MOD;
            out.println(x);
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
                    throw new RuntimeException(e);
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

