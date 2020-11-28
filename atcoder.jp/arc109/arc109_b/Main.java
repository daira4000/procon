import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.math.BigInteger;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.function.Function;
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
        B solver = new B();
        solver.solve(1, in, out);
        out.close();
    }

    static class B {
        long n;

        public void solve(int testNumber, MyScanner in, PrintWriter out) {
            n = in.Long();
            BigInteger n1 = BigInteger.valueOf(n + 1);
            long a = nibu(n + 1, l -> {
                BigInteger x = BigInteger.valueOf(l);
                x = x.multiply(BigInteger.valueOf(l + 1)).divide(BigInteger.TWO);
                return x.compareTo(n1) > 0;
            });
            out.println(n - (a - 1) + 1);
        }

        private long nibu(long n, Function<Long, Boolean> check) {
            long ng = -1, ok = n;
            while (Math.abs(ok - ng) > 1) {
                long mid = (ng + ok) / 2;
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

        public long Long() {
            return Long.parseLong(next());
        }

    }
}

