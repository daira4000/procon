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
        static long MOD = (long) 1e9 + 7;

        public void solve(int testNumber, MyScanner in, PrintWriter out) {
            int N = in.nextInt();
            char[][] S = new char[2][];
            S[0] = in.next().toCharArray();
            S[1] = in.next().toCharArray();

            long[] dp = new long[N];
            dp[0] = 3 * (S[0][0] == S[1][0] ? 1 : 2);
            for (int i = 1; i < N; i++) {
                if (S[0][i - 1] == S[0][i]) {
                    dp[i] = dp[i - 1];
                } else if (S[0][i - 1] == S[1][i - 1]) {
                    dp[i] = dp[i - 1] * 2 % MOD;
                } else {
                    if (S[0][i] == S[1][i]) {
                        dp[i] = dp[i - 1];
                    } else {
                        dp[i] = dp[i - 1] * 3 % MOD;
                    }
                }
            }
            out.println(dp[N - 1]);
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

