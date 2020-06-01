import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Arrays;
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
        D solver = new D();
        solver.solve(1, in, out);
        out.close();
    }

    static class D {
        public void solve(int testNumber, MyScanner in, PrintWriter out) {
            long N = in.Long();

            int n = (int) Math.sqrt(N);
            boolean[] prime = new boolean[n + 1];
            Arrays.fill(prime, true);
            prime[0] = false;
            prime[1] = false;
            for (int i = 2; i <= n; i++) {
                if (prime[i]) {
                    for (int j = i * 2; j <= n; j += i) {
                        prime[j] = false;
                    }
                }
            }
            Set<Long> set = new HashSet<>();
            for (int i = 2; i <= n; i++) {
                if (prime[i]) {
                    for (int j = i; j <= n; j *= i) {
                        if (N % j == 0) {
                            set.add((long) j);
                            N /= j;
                        }
                    }
                }
            }
            if (N > n) set.add(N);
            out.println(set.size());
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

        public long Long() {
            return Long.parseLong(next());
        }

    }
}

