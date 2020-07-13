import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.stream.IntStream;
import java.util.Arrays;
import java.util.Set;
import java.io.IOException;
import java.util.stream.Collectors;
import java.util.function.Function;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.stream.Stream;
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
        H solver = new H();
        solver.solve(1, in, out);
        out.close();
    }

    static class H {
        public void solve(int testNumber, MyScanner in, PrintWriter out) {
            int N = in.Int();
            int L = in.Int();
            int[] x = in.Int(N);
            int[] T = in.Int(3);

            Set<Integer> hurdle = IntStream.of(x).boxed().collect(Collectors.toCollection(HashSet::new));

            long[] dp = new long[100000 + 5];
            Arrays.fill(dp, 1L << 60);
            dp[0] = 0;
            Function<Integer, Integer> h = p -> hurdle.contains(p) ? T[2] : 0;
            for (int i = 0; i < L; i++) {
                // 1
                dp[i + 1] = Math.min(dp[i + 1], dp[i] + T[0] + h.apply(i + 1));
                // 3
                if (i + 1 == L) dp[i + 1] = Math.min(dp[i + 1], dp[i] + T[0] / 2 + T[1] / 2);
                if (i + 2 == L) dp[i + 2] = Math.min(dp[i + 2], dp[i] + T[0] / 2 + T[1] / 2 + T[1]);
                if (i + 3 == L) dp[i + 3] = Math.min(dp[i + 3], dp[i] + T[0] / 2 + T[1] / 2 + T[1] * 2);
                dp[i + 4] = Math.min(dp[i + 4], dp[i] + T[0] + T[1] * 3 + h.apply(i + 4));
                // 2
                dp[i + 2] = Math.min(dp[i + 2], dp[i] + T[0] + T[1] + h.apply(i + 2));
            }
            out.println(dp[L]);
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

