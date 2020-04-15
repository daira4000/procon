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
        public void solve(int testNumber, MyScanner in, PrintWriter out) {
            int N = in.Int();
            int M = in.Int();
            int[] a = new int[M];
            int[] b = new int[M];
            int[] t = new int[M];
            for (int i = 0; i < M; i++) {
                a[i] = in.Int() - 1;
                b[i] = in.Int() - 1;
                t[i] = in.Int();
            }
            int[][] dp = new int[N][N];
            for (int i = 0; i < N; i++) {
                Arrays.fill(dp[i], (int) 1e8);
                dp[i][i] = 0;
            }
            for (int i = 0; i < M; i++) {
                dp[a[i]][b[i]] = t[i];
                dp[b[i]][a[i]] = t[i];
            }
            for (int k = 0; k < N; k++) {
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                    }
                }
            }
            int ans = (int) 1e8;
            for (int i = 0; i < N; i++) {
                int temp = 0;
                for (int j = 0; j < N; j++) {
                    temp = Math.max(temp, dp[i][j]);
                }
                ans = Math.min(ans, temp);
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

    }
}

