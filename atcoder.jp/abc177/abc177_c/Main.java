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
        static long MOD = (long) (1e9 + 7);
        int N;
        int[] A;

        public void solve(int testNumber, MyScanner in, PrintWriter out) {
            N = in.Int();
            A = in.Int(N);

//        long ans1 = calc1();
//        out.println(ans1);
            long ans2 = calc2();
            out.println(ans2);
        }

        public long calc2() {
            long[] as = new long[N + 1];
            for (int i = 0; i < N; i++) {
                as[i + 1] = (as[i] + A[i]) % MOD;
            }
            long ret = 0;
            for (int i = 0; i < N - 1; i++) {
                long l = (as[N] - as[i + 1] + MOD) % MOD;
                ret += (A[i] * l) % MOD;
                ret %= MOD;
            }
            return ret;
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

