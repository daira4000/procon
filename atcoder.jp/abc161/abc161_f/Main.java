import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.Set;
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
        F solver = new F();
        solver.solve(1, in, out);
        out.close();
    }

    static class F {
        public void solve(int testNumber, MyScanner in, PrintWriter out) {
            long N = in.nextLong();
            int ans = 0;
            Set<Long> set = new HashSet<>();
            set.add(N);
            set.add(N - 1);
            long a = N - 1;
            for (long i = 2; i < Math.sqrt(a) + 1; i++) {
                if (a % i == 0) {
                    set.add(i);
                    set.add(a / i);
                }
            }
//        ans += set.size() + 1;
//        set.clear();
            for (long i = 2; i < Math.sqrt(N) + 1; i++) {
                if (N % i == 0) {
                    set.add(i);
                    set.add(N / i);
                }
            }
            for (Long k : set) {
                if (k == 1) continue;
                a = N;
                while (a % k == 0) a /= k;
                if (a % k == 1) ans++;
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

        public long nextLong() {
            return Long.parseLong(next());
        }

    }
}

