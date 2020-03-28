import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.stream.LongStream;
import java.io.IOException;
import java.io.InputStreamReader;
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
        E solver = new E();
        solver.solve(1, in, out);
        out.close();
    }

    static class E {
        public void solve(int testNumber, MyScanner in, PrintWriter out) {
            int X = in.nextInt();
            int Y = in.nextInt();
            int A = in.nextInt();
            int B = in.nextInt();
            int C = in.nextInt();
            long[] p = in.nextLongArray(A);
            long[] q = in.nextLongArray(B);
            long[] r = in.nextLongArray(C);
            Arrays.sort(p);
            Arrays.sort(q);
            Arrays.sort(r);
            long[] ps = Arrays.copyOfRange(p, A - X, A);
            long[] qs = Arrays.copyOfRange(q, B - Y, B);
            long[] ls = new long[X + Y];
            System.arraycopy(ps, 0, ls, 0, X);
            System.arraycopy(qs, 0, ls, X, Y);
            Arrays.sort(ls);
            long sum = LongStream.of(ls).sum();
            for (int i = 0; i < X + Y && i < C; i++) {
                long v = ls[i];
                if (v < r[C - 1 - i]) {
                    sum += r[C - 1 - i] - v;
                }
            }
            out.println(sum);
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

        public long nextLong() {
            return Long.parseLong(next());
        }

        public long[] nextLongArray(int n) {
            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextLong();
            }
            return a;
        }

    }
}

