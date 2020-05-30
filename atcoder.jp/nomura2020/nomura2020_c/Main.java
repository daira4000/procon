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
            int[] A = in.Int(N + 1);
            if (N == 0) {
                if (A[0] <= 1) {
                    out.println(1);
                } else {
                    out.println(-1);
                }
                return;
            }
            if (N > 0 && A[0] > 0) {
                out.println(-1);
                return;
            }

            long[] B = new long[N + 1];
            B[N] = A[N];
            for (int i = N - 1; i >= 0; i--) {
                B[i] = B[i + 1] + A[i];
            }

            long ans = 1;
            long cur = 1;
            for (int i = 1; i < N; i++) {
                long temp = cur * 2 - A[i];
                if (temp <= 0) {
                    out.println(-1);
                    return;
                }
                cur = Math.min(temp, B[i + 1]);
                ans += cur + A[i];
            }
            if (cur > A[N] || cur * 2 < A[N]) {
                out.println(-1);
            } else {
                out.println(ans + A[N]);
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

