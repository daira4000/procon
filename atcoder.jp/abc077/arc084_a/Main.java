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
        C solver = new C();
        solver.solve(1, in, out);
        out.close();
    }

    static class C {
        public void solve(int testNumber, MyScanner in, PrintWriter out) {
            int N = in.Int();
            int[] A = in.Int(N);
            int[] B = in.Int(N);
            int[] C = in.Int(N);
            Arrays.sort(A);
            Arrays.sort(B);
            Arrays.sort(C);

            int[] bi = new int[N];
            long[] cntB = new long[N + 1];
            int j = 0;
            for (int i = 0; i < N; i++) {
                while (j < N && A[i] >= B[j]) j++;
                bi[i] = j;
            }
            j = 0;
            for (int i = 0; i < N; i++) {
                while (j < N && B[i] >= C[j]) j++;
                cntB[i + 1] = (N - j) + cntB[i];
            }
            long ans = 0;
            for (int i = 0; i < N; i++) {
                ans += (cntB[N] - cntB[bi[i]]);
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

        public int[] Int(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Int();
            }
            return a;
        }

    }
}

