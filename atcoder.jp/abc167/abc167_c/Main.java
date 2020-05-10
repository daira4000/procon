import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.stream.IntStream;
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
            int X = in.Int();
            int[] C = new int[N];
            int[][] A = new int[N][];
            for (int i = 0; i < N; i++) {
                C[i] = in.Int();
                A[i] = in.Int(M);
            }
            long lm = 1 << N;
            int cost = Integer.MAX_VALUE;
            for (int i = 0; i < lm; i++) {
                int[] v = new int[M];
                int temp = 0;
                for (int j = 0; j < N; j++) {
                    if (((i >> j) & 1) == 1) {
                        temp += C[j];
                        for (int k = 0; k < M; k++) {
                            v[k] += A[j][k];
                        }
                    }
                }
                boolean chk = IntStream.of(v).allMatch(n -> n >= X);
                if (chk) {
                    cost = Math.min(cost, temp);
                }
            }
            out.println(cost == Integer.MAX_VALUE ? -1 : cost);
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

