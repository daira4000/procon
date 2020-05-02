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
        D solver = new D();
        solver.solve(1, in, out);
        out.close();
    }

    static class D {
        public void solve(int testNumber, MyScanner in, PrintWriter out) {
            int N = in.Int();
            int[] H = new int[N];
            int[] S = new int[N];
            long smax = 0;
            for (int i = 0; i < N; i++) {
                H[i] = in.Int();
                S[i] = in.Int();
                smax = Math.max(smax, H[i] + (long) S[i] * N);
            }

            long X = nibu(smax, x -> {
                long[] t = new long[N];
                for (int i = 0; i < N; i++) {
                    if (x < H[i]) {
                        return false;
                    }
                    t[i] = (x - H[i]) / S[i];
                }
                Arrays.sort(t);
                for (int i = 0; i < N; i++) {
                    if (t[i] < i) {
                        return false;
                    }
                }
                return true;
            });
            out.println(X);
        }

        private long nibu(long n, Function<Long, Boolean> check) {
            long ng = -1, ok = n;
            while (Math.abs(ok - ng) > 1) {
                long mid = (ng + ok) / 2;
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
                    throw new RuntimeException(e);
                }
            }
            return st.nextToken();
        }

        public int Int() {
            return Integer.parseInt(next());
        }

    }
}

