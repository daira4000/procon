import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
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
        long[] a;
        long X;

        public void solve(int testNumber, MyScanner in, PrintWriter out) {
            int N = in.nextInt();
            int Q = in.nextInt();
            long[] A = in.nextLongArray(N);
            long[] S = in.nextLongArray(Q);

            a = Arrays.copyOf(A, N);
            for (int i = 1; i < N; i++) {
                a[i] = gcd(a[i - 1], a[i]);
            }
            for (long b : S) {
                X = b;
                long x = gcd(X, a[N - 1]);
                if (x == 1) {
                    int r = nibu(N);
                    out.println(r + 1);
                } else {
                    out.println(x);
                }
            }
        }

        private int nibu(int n) {
            int ng = -1, ok = n;
            while (Math.abs(ok - ng) > 1) {
                int mid = (ng + ok) / 2;
                boolean f = nibucheck(mid);
                if (f) {
                    ng = mid;
                } else {
                    ok = mid;
                }
            }
            return ok;
        }

        private boolean nibucheck(int mid) {
            return gcd(X, a[mid]) > 1;
        }

        long gcd(long a, long b) {
            return b == 0 ? a : gcd(b, a % b);
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

