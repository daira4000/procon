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
        public void solve(int testNumber, MyScanner in, PrintWriter out) {
            int N = in.Int();
            int K = in.Int();
            int[] A = in.Int(N);
            Arrays.sort(A);

            long ans = nibu(A[N - 1], t -> {
                int k = K;
                for (int i = 0; i < N; i++) {
                    int a = A[N - 1 - i];
                    k -= ((int) Math.ceil((double) a / t)) - 1;
                    if (k < 0) return false;
                }
                return true;
            });
            out.println(ans);
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

