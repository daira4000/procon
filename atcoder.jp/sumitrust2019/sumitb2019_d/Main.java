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
        public void solve(int testNumber, MyScanner in, PrintWriter out) {
            int N = in.nextInt();
            String S = in.next();

            boolean[][] dp = new boolean[3][1000];
            for (int i = 0; i < N; i++) {
                int c = S.charAt(i) - '0';
                if (i > 1) {
                    for (int j = 0; j < 100; j++) {
                        dp[2][j * 10 + c] |= dp[1][j];
                    }
                }
                if (i > 0) {
                    for (int j = 0; j < 10; j++) {
                        dp[1][j * 10 + c] |= dp[0][j];
                    }
                }
                dp[0][c] = true;
            }
            int cnt = 0;
            for (int i = 0; i < 1000; i++) {
                if (dp[2][i]) {
                    cnt++;
                }
            }
            out.println(cnt);
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

