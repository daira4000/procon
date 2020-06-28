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
        B solver = new B();
        solver.solve(1, in, out);
        out.close();
    }

    static class B {
        public void solve(int testNumber, MyScanner in, PrintWriter out) {
            int D = in.Int();
            int N = 26;
            int[] c = in.Int(N);
            int[][] s = new int[D][N];
            for (int i = 0; i < D; i++) {
                s[i] = in.Int(N);
            }
            int[] t = new int[D];
            for (int i = 0; i < D; i++) {
                t[i] = in.Int() - 1;
            }

            int score = 0;
            int[] last = new int[N];
            for (int d = 0; d < D; d++) {
                score += s[d][t[d]];
                last[t[d]] = d + 1;
                for (int i = 0; i < N; i++) {
                    if (t[d] != i) {
                        score -= c[i] * ((d + 1) - last[i]);
                    }
                }
                out.println(score);
            }
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

