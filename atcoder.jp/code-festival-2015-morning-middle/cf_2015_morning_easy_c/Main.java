import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.stream.LongStream;
import java.util.Collection;
import java.io.IOException;
import java.util.stream.Collectors;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;
import java.util.StringTokenizer;
import java.util.Optional;
import java.io.BufferedReader;
import java.util.Comparator;
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
        A solver = new A();
        solver.solve(1, in, out);
        out.close();
    }

    static class A {
        public void solve(int testNumber, MyScanner in, PrintWriter out) {
            int N = in.Int();
            int K = in.Int();
            long M = in.Int();
            long R = in.Int();
            long[] S = in.Long(N - 1);
            List<Long> list = LongStream.of(S).boxed().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
            if (list.size() > K) {
                list = list.subList(0, K);
            } else if (list.size() < K) {
                list.add(0L);
            }
            long sum = list.stream().mapToLong(Long::valueOf).sum();
            long border = K * R;
            if (border <= sum) {
                out.println(0);
            } else {
                long min = list.stream().min(Comparator.naturalOrder()).get();
                long ans = Math.max(0, border - (sum - min));
                if (M < ans) {
                    out.println(-1);
                } else {
                    out.println(ans);
                }
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
                    throw new RuntimeException(e);
                }
            }
            return st.nextToken();
        }

        public int Int() {
            return Integer.parseInt(next());
        }

        public long Long() {
            return Long.parseLong(next());
        }

        public long[] Long(int n) {
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = Long();
            }
            return a;
        }

    }
}

