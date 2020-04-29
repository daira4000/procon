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
        B solver = new B();
        solver.solve(1, in, out);
        out.close();
    }

    static class B {
        public void solve(int testNumber, MyScanner in, PrintWriter out) {
            int N = in.Int();
            int K = in.Int();
            long[] a = in.Long(N);

            long ans = 1L << 60;
            int m = 1 << N;
            for (int p = 0; p < m; p++) {
                long temp = 0;
                long max = 0;
                int cnt = 0;
                for (int i = 0; i < N; i++) {
                    long len = a[i];
                    if (((p >> i) & 1) == 1) {
                        if (len < max + 1) {
                            temp += max + 1 - len;
                            len = max + 1;
                        }
                    }
                    if (max < len) {
                        max = len;
                        cnt++;
                    }
                }
                if (cnt >= K) {
                    ans = Math.min(ans, temp);
                }
            }
            out.println(ans);
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

