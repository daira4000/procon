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
        C solver = new C();
        solver.solve(1, in, out);
        out.close();
    }

    static class C {
        int D;
        int G;
        int[] p;
        int[] c;

        public void solve(int testNumber, MyScanner in, PrintWriter out) {
            D = in.Int();
            G = in.Int();
            p = new int[D];
            c = new int[D];
            for (int i = 0; i < D; i++) {
                p[i] = in.Int();
                c[i] = in.Int();
            }

            int ans = 1000000;
            for (int i = 0; i < D; i++) {
                ans = Math.min(ans, calc(0, 1 << i, i + 1));
            }
            out.println(ans);
        }

        private int calc(int score, int a, int b) {
            int ans = 0;
            for (int i = 1; i <= p[b - 1]; i++) {
                if (score >= G) {
                    return ans;
                }
                score += b * 100;
                ans++;
            }
            score += c[b - 1];
            if (score >= G) {
                return ans;
            }
            int temp = 10000000;
            for (int i = 0; i < D; i++) {
                int c = a | (1 << i);
                if (a != c) {
                    temp = Math.min(temp, calc(score, c, i + 1));
                }
            }

            return ans + temp;
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

