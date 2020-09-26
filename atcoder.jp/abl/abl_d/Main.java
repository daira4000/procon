import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.function.BiFunction;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.BinaryOperator;
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
        int K;
        int[] A;

        public void solve(int testNumber, MyScanner in, PrintWriter out) {
            N = in.Int();
            K = in.Int();
            A = in.Int(N);

            Integer[] dat = new Integer[300005];
            Arrays.setAll(dat, i -> 0);
            SegTree<Integer> seg = new SegTree<>(dat, Math::max, 0);

            int ans = 0;
            for (int i = 0; i < N; i++) {
                int a = A[i];
                int l = Math.max(0, a - K);
                int r = Math.min(a + K + 1, dat.length - 2);
                int now = seg.prod(l, r) + 1;
                if (now > ans) ans = now;
                seg.set(a, now);
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

    static class SegTree<S> {
        final int MAX;
        final int N;
        final BinaryOperator<S> op;
        final S E;
        final S[] data;

        public SegTree(int n, BinaryOperator<S> op, S e) {
            this.MAX = n;
            int k = 1;
            while (k < n) k <<= 1;
            this.N = k;
            this.E = e;
            this.op = op;
            this.data = (S[]) new Object[N << 1];
            Arrays.fill(data, E);
        }

        public SegTree(S[] dat, BinaryOperator<S> op, S e) {
            this(dat.length, op, e);
            build(dat);
        }

        private void build(S[] dat) {
            int l = dat.length;
            System.arraycopy(dat, 0, data, N, l);
            for (int i = N - 1; i > 0; i--) {
                data[i] = op.apply(data[i << 1 | 0], data[i << 1 | 1]);
            }
        }

        public void set(int p, S x) {
            exclusiveRangeCheck(p);
            data[p += N] = x;
            p >>= 1;
            while (p > 0) {
                data[p] = op.apply(data[p << 1 | 0], data[p << 1 | 1]);
                p >>= 1;
            }
        }

        public S prod(int l, int r) {
            if (l > r) {
                throw new IllegalArgumentException(
                        String.format("Invalid range: [%d, %d)", l, r)
                );
            }
            inclusiveRangeCheck(l);
            inclusiveRangeCheck(r);
            S sumLeft = E;
            S sumRight = E;
            l += N;
            r += N;
            while (l < r) {
                if ((l & 1) == 1) sumLeft = op.apply(sumLeft, data[l++]);
                if ((r & 1) == 1) sumRight = op.apply(data[--r], sumRight);
                l >>= 1;
                r >>= 1;
            }
            return op.apply(sumLeft, sumRight);
        }

        private void exclusiveRangeCheck(int p) {
            if (p < 0 || p >= MAX) {
                throw new IndexOutOfBoundsException(
                        String.format("Index %d out of bounds for the range [%d, %d).", p, 0, MAX)
                );
            }
        }

        private void inclusiveRangeCheck(int p) {
            if (p < 0 || p > MAX) {
                throw new IndexOutOfBoundsException(
                        String.format("Index %d out of bounds for the range [%d, %d].", p, 0, MAX)
                );
            }
        }

        public String toString() {
            return toSimpleString();
        }

        public String toSimpleString() {
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            for (int i = 0; i < N; i++) {
                sb.append(data[i + N]);
                if (i < N - 1) sb.append(',').append(' ');
            }
            sb.append(']');
            return sb.toString();
        }

    }
}

