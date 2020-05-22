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
        arc076_a solver = new arc076_a();
        solver.solve(1, in, out);
        out.close();
    }

    static class arc076_a {
        static long MOD = (long) (1e9 + 7);

        public void solve(int testNumber, MyScanner in, PrintWriter out) {
            int N = in.Int();
            int M = in.Int();
            if (Math.abs(N - M) > 1) {
                out.println(0);
                return;
            }

            long n = 1;
            for (int i = 2; i <= N; i++) {
                n *= i;
                n %= MOD;
            }
            long m = 1;
            for (int i = 2; i <= M; i++) {
                m *= i;
                m %= MOD;
            }
            long ans = n * m % MOD;
            if (N == M) ans *= 2;
            ans %= MOD;
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

