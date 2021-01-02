import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Function;
import java.util.StringTokenizer;
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
        int N;
        int[][] P;

        public void solve(int testNumber, MyScanner in, PrintWriter out) {
            N = in.Int();
            P = new int[N][];
            for (int i = 0; i < N; i++) {
                P[i] = in.Int(2);
            }
            Arrays.sort(P, (o1, o2) -> {
                int c = Long.compare(o2[0] * 2L + o2[1], o1[0] * 2L + o1[1]);
                if (c == 0) c = Integer.compare(o2[0], o1[0]);
                return c;
            });
            long[] sum = new long[N + 1];
            long[] suma = new long[N + 1];
            for (int i = 0; i < N; i++) {
                sum[i + 1] += sum[i] + P[i][0] * 2L + P[i][1];
                suma[i + 1] += suma[i] + P[i][0];
            }
            int ret = nibu(N, i -> {
                return suma[N] < sum[i];
            });
            out.println(ret);
        }

        private int nibu(int n, Function<Integer, Boolean> check) {
            int ng = -1, ok = n;
            while (Math.abs(ok - ng) > 1) {
                int mid = (ng + ok) / 2;
                boolean f = check.apply(mid);
                if (!f) {
                    ng = mid;
                } else {
                    ok = mid;
                }
            }
            return ok;
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

