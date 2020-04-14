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
        F solver = new F();
        solver.solve(1, in, out);
        out.close();
    }

    static class F {
        public void solve(int testNumber, MyScanner in, PrintWriter out) {
            String s = in.next();
            String t = in.next();
            int sl = s.length();
            int tl = t.length();
            int[][] dp = new int[sl + 1][tl + 1];
            for (int i = 0; i < sl; i++) {
                for (int j = 0; j < tl; j++) {
                    if (s.charAt(i) == t.charAt(j)) {
                        dp[i + 1][j + 1] = Math.max(dp[i][j + 1], Math.max(dp[i + 1][j], dp[i][j] + 1));
                    } else {
                        dp[i + 1][j + 1] = Math.max(dp[i][j + 1], Math.max(dp[i + 1][j], dp[i][j]));
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            while (sl > 0 && tl > 0 && dp[sl][tl] > 0) {
                while (dp[sl - 1][tl] == dp[sl][tl]) sl--;
                while (dp[sl][tl - 1] == dp[sl][tl]) tl--;
                sb.append(s.charAt(sl - 1));
                sl--;
                tl--;
            }
            out.println(sb.reverse().toString());
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

    }
}

