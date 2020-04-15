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
        public void solve(int testNumber, MyScanner in, PrintWriter out) {
            int N = in.Int();
            int M = in.Int();
            int[][] A = new int[N][M];
            for (int i = 0; i < N; i++) {
                A[i] = in.Int(M);
            }

            long[] scores = new long[M];
            for (int m = 0; m < M; m++) {
                for (int m2 = m + 1; m2 < M; m2++) {
                    long temp = 0;
                    for (int n = 0; n < N; n++) {
                        temp += Math.max(A[n][m], A[n][m2]);
                    }
                    scores[m] = Math.max(scores[m], temp);
                }
                if (m > 0) {
                    scores[m] = Math.max(scores[m - 1], scores[m]);
                }
            }
            out.println(scores[M - 1]);
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

        public int[] Int(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Int();
            }
            return a;
        }

    }
}

