import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.math.BigInteger;
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
        B solver = new B();
        solver.solve(1, in, out);
        out.close();
    }

    static class B {
        public void solve(int testNumber, MyScanner in, PrintWriter out) {
            int N = in.Int();
            long[] A = in.Long(N);

            for (int i = 0; i < N; i++) {
                if (A[i] == 0) {
                    out.println(0);
                    return;
                }
            }

            BigInteger max = BigInteger.valueOf((long) 1e18);

            BigInteger a = BigInteger.ONE;
            for (int i = 0; i < N; i++) {
                a = a.multiply(BigInteger.valueOf(A[i]));
                if (a.compareTo(max) > 0) {
                    out.println(-1);
                    return;
                }
            }
            out.println(a.toString());
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

        public long Long() {
            return Long.parseLong(next());
        }

        public long[] Long(int n) {
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = Long();
            }
            return a;
        }

    }
}

