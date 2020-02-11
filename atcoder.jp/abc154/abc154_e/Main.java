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
        E solver = new E();
        solver.solve(1, in, out);
        out.close();
    }

    static class E {
        public void solve(int testNumber, MyScanner in, PrintWriter out) {
            String N = in.next();
            int K = in.nextInt();

            int length = N.length();
            long[][][] dp = new long[length + 1][K + 1][2];
            dp[0][0][0] = 1;
            for (int i = 0; i < length; i++) {
                int c = N.charAt(i) - '0';
                for (int k = 0; k <= K; k++) {
                    for (int l = 0; l < 2; l++) {
                        for (int n = 0; n < 10; n++) {
                            int kk = k, ll = l;
                            if (n > 0) kk++;
                            if (kk > K) continue;
                            if (ll == 0) {
                                if (n > c) continue;
                                if (n < c) ll++;
                            }
                            dp[i + 1][kk][ll] += dp[i][k][l];
                        }
                    }
                }
            }
            out.println(dp[length][K][0] + dp[length][K][1]);
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

