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
            int Q = in.Int();
            int[] a = new int[Q];
            int[] b = new int[Q];
            int[] c = new int[Q];
            int[] d = new int[Q];
            for (int i = 0; i < Q; i++) {
                a[i] = in.Int() - 1;
                b[i] = in.Int() - 1;
                c[i] = in.Int();
                d[i] = in.Int();
            }

            int max = 0;
            for (int i = 1; i <= M; i++) {
                int[] A = new int[N];
                A[0] = i;
                int temp = calc(N, M, a, b, c, d, A, 0);
                max = Math.max(max, temp);
            }
            out.println(max);

        }

        private int calc(int N, int M, int[] a, int[] b, int[] c, int[] d, int[] A, int i) {
            if (i + 1 == N) {
                int Q = a.length;
                int ret = 0;
                for (int j = 0; j < Q; j++) {
                    if (A[b[j]] - A[a[j]] == c[j]) {
                        ret += d[j];
                    }
                }
                return ret;
            }
            int ii = i + 1;
            int max = 0;
            for (int j = A[i]; j <= M; j++) {
                A[ii] = j;
                int temp = calc(N, M, a, b, c, d, A, ii);
                max = Math.max(max, temp);
            }
            A[ii] = A[i];
            return max;
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

