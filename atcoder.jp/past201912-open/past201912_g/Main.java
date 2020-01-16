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
        G solver = new G();
        solver.solve(1, in, out);
        out.close();
    }

    static class G {
        public void solve(int testNumber, MyScanner in, PrintWriter out) {
            int N = in.nextInt();
            int[][] as = new int[N - 1][N];
            for (int i = 0; i < N - 1; i++) {
                for (int j = i + 1; j < N; j++) {
                    as[i][j] = in.nextInt();
                }
            }

            char[] cs = new char[N];
            Arrays.fill(cs, '2');
            int loopMax = Integer.parseInt(String.valueOf(cs), 3);
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < loopMax; i++) {
                int score = calc(N, as, Integer.toString(i, 3));
                max = Math.max(max, score);
            }
            out.println(max);
        }

        private int calc(int N, int[][] as, String s) {
            int len = s.length();
            int ret = 0;
            for (int i = 0; i < N - 1; i++) {
                char grp1 = '0';
                if (len > i) grp1 = s.charAt(i);
                for (int j = i + 1; j < N; j++) {
                    char grp2 = '0';
                    if (len > j) grp2 = s.charAt(j);
                    if (grp1 == grp2) ret += as[i][j];
                }
            }
            return ret;
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

