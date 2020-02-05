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
        D solver = new D();
        solver.solve(1, in, out);
        out.close();
    }

    static class D {
        public void solve(int testNumber, MyScanner in, PrintWriter out) {
            int N = in.nextInt();
            long M = in.nextLong();
            long[] a = in.nextLongArray(N);

            for (int i = 0; i < N; i++) {
                a[i] /= 2;
            }
            int t = f(a[0]);
            for (int i = 0; i < N; i++) {
                if (t != f(a[i])) {
                    out.println(0);
                    return;
                }
                a[i] >>= t;
            }
            M >>= t;

            long lcm = 1;
            for (int i = 0; i < N; i++) {
                lcm = lcm(lcm, a[i]);
                if (lcm > M) {
                    out.println(0);
                    return;
                }
            }
            M = M / lcm;
            long ans = (M + 1) / 2;
            out.println(ans);
        }

        int f(long a) {
            int ret = 0;
            while (a % 2 == 0) {
                ret++;
                a /= 2;
            }
            return ret;
        }

        long gcd(long a, long b) {
            return b == 0 ? a : gcd(b, a % b);
        }

        long lcm(long a, long b) {
            return a / gcd(a, b) * b;
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

        public long nextLong() {
            return Long.parseLong(next());
        }

        public long[] nextLongArray(int n) {
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextLong();
            }
            return a;
        }

    }
}

