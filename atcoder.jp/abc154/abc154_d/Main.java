import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Map;
import java.io.BufferedReader;
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
        D solver = new D();
        solver.solve(1, in, out);
        out.close();
    }

    static class D {
        public void solve(int testNumber, MyScanner in, PrintWriter out) {
            int N = in.nextInt();
            int K = in.nextInt();
            int[] p = in.nextIntArray(N);

            Map<Integer, Double> map = new HashMap<>();
            int sum = 0;
            for (int i = 1; i <= 1000; i++) {
                sum += i;
                map.put(i, sum / (double) i);
            }

            double[] tmp = new double[N + 1];
            for (int i = 1; i <= N; i++) {
                tmp[i] = tmp[i - 1] + map.get(p[i - 1]);
            }
            double ans = 0;
            for (int i = 0; i <= N - K; i++) {
                ans = Math.max(ans, tmp[i + K] - tmp[i]);
            }
            out.printf("%.12f\n", ans);
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

        public int[] nextIntArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextInt();
            }
            return a;
        }

    }
}

