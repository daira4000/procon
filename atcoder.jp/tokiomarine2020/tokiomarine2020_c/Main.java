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
            int K = in.Int();
            int[] A = in.Int(N);

            while (K-- > 0) {
                int[] B = new int[N + 1];
                for (int i = 0; i < N; i++) {
                    int l = Math.max(0, i - A[i]);
                    int r = Math.min(N - 1, i + A[i]) + 1;
                    B[l] += 1;
                    B[r] -= 1;
                }
                int v = 0;
                int min = N;
                for (int i = 0; i < N; i++) {
                    v += B[i];
                    A[i] = v;
                    min = Math.min(A[i], min);
                }
                if (min == N) break;
            }
            StringBuilder sb = new StringBuilder();
            for (int a : A) {
                sb.append(a).append(' ');
            }
            out.println(sb.substring(0, sb.length() - 1));
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

