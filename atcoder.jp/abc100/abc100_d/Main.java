import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
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
        int M;
        long[] x;
        long[] y;
        long[] z;

        public void solve(int testNumber, MyScanner in, PrintWriter out) {
            N = in.Int();
            M = in.Int();
            x = new long[N];
            y = new long[N];
            z = new long[N];
            for (int i = 0; i < N; i++) {
                x[i] = in.Long();
                y[i] = in.Long();
                z[i] = in.Long();
            }
            List<D.Cake> list = new ArrayList<>(N);
            for (int i = 0; i < N; i++) {
                list.add(new D.Cake(x[i], y[i], z[i]));
            }

            long[] op = new long[]{1, -1};
            long max = 0;
            for (int i = 0; i < 8; i++) {
                int q = i;
                list.sort((o1, o2) -> {
                    long a = op[q & 1] * o1.x + op[q >> 1 & 1] * o1.y + op[q >> 2 & 1] * o1.z;
                    long b = op[q & 1] * o2.x + op[q >> 1 & 1] * o2.y + op[q >> 2 & 1] * o2.z;
                    return Long.compare(b, a);
                });
                long xs = 0, ys = 0, zs = 0;
                for (int j = 0; j < M; j++) {
                    xs += list.get(j).x;
                    ys += list.get(j).y;
                    zs += list.get(j).z;
                }
                max = Math.max(max, Math.abs(xs) + Math.abs(ys) + Math.abs(zs));
            }
            out.println(max);
        }

        static class Cake {
            long x;
            long y;
            long z;

            Cake(long _x, long _y, long _z) {
                x = _x;
                y = _y;
                z = _z;
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

    }
}

