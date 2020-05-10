import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.stream.IntStream;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.OptionalInt;
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
        D solver = new D();
        solver.solve(1, in, out);
        out.close();
    }

    static class D {
        int N;
        long K;
        int[] A;

        public void solve(int testNumber, MyScanner in, PrintWriter out) {
            N = in.Int();
            K = in.Long();
            A = in.Int(N);

            int[] cnt = new int[N];
            Arrays.fill(cnt, -1);
            cnt[0] = 0;
            int cur = 0;
            while (cnt[A[cur] - 1] < 0) {
                cnt[A[cur] - 1] = cnt[cur] + 1;
                cur = A[cur] - 1;
            }
            int ls = cnt[A[cur] - 1];
            int max = IntStream.of(cnt).max().getAsInt();
            int lc;
            if (K <= ls) {
                lc = (int) K;
            } else {
                lc = (int) ((K - ls) % (max + 1L - ls)) + ls;
            }
            for (int i = 0; i < N; i++) {
                if (cnt[i] == lc) {
                    out.println(i + 1);
                    return;
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
                    return null;
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

        public int[] Int(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Int();
            }
            return a;
        }

    }
}

