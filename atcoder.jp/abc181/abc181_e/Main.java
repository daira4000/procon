import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Function;
import java.util.StringTokenizer;
import java.io.BufferedReader;
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
        E solver = new E();
        solver.solve(1, in, out);
        out.close();
    }

    static class E {
        int N;
        int M;
        int[] H;
        int[] W;

        public void solve(int testNumber, MyScanner in, PrintWriter out) {
            N = in.Int();
            M = in.Int();
            H = in.Int(N);
            Arrays.sort(H);
            W = in.Int(M);
            Arrays.sort(W);

            long[] dh1 = new long[N / 2 + 1];
            for (int i = 0; i < dh1.length - 1; i++) {
                dh1[i + 1] = dh1[i] + (H[i * 2 + 1] - H[i * 2]);
            }
            long[] dh2 = new long[N / 2 + 1];
            for (int i = 0; i < dh2.length - 1; i++) {
                dh2[i + 1] = dh2[i] + (H[i * 2 + 2] - H[i * 2 + 1]);
            }

            long min = Long.MAX_VALUE;
            for (int w : W) {
                int idx = nibu(N, i -> H[i] > w);
                long a = dh1[idx / 2];
                long b = dh2[dh2.length - 1] - dh2[idx / 2];
                long c;
                if ((idx & 1) == 0) {
                    c = idx < N ? Math.abs(w - H[idx]) : Math.abs(w - H[N - 1]);
                } else {
                    c = idx < N ? Math.abs(w - H[idx - 1]) : Math.abs(w - H[N - 1]);
                }
                min = Math.min(min, a + b + c);
            }
            out.println(min);

        }

        private int nibu(int n, Function<Integer, Boolean> check) {
            int ng = -1, ok = n;
            while (Math.abs(ok - ng) > 1) {
                int mid = (ng + ok) / 2;
                boolean f = check.apply(mid);
                if (!f) {
                    ng = mid;
                } else {
                    ok = mid;
                }
            }
            return ok;
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

        public int[] Int(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Int();
            }
            return a;
        }

    }
}

