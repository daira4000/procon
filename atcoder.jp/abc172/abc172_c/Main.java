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
            int K = in.Int();
            int[] A = in.Int(N);
            int[] B = in.Int(M);

            long[] as = new long[N + 1];
            for (int i = 0; i < N; i++) {
                as[i + 1] += as[i] + A[i];
            }
            long[] bs = new long[M + 1];
            for (int i = 0; i < M; i++) {
                bs[i + 1] += bs[i] + B[i];
            }
            int ans = 0;
            int i = 0;
            while (i < N && as[i + 1] <= K) i++;
            int j = 0;
            while (i >= 0) {
                while (j < M && as[i] + bs[j + 1] <= K) j++;
                ans = Math.max(ans, i + j);
                i--;
            }
            out.println(ans);
//        out.println(Arrays.toString(as));
//        out.println(Arrays.toString(bs));
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

