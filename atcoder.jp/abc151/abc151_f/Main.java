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
        F solver = new F();
        solver.solve(1, in, out);
        out.close();
    }

    static class F {
        public void solve(int testNumber, MyScanner in, PrintWriter out) {
            int N = in.nextInt();
            int[] x = new int[N];
            int[] y = new int[N];
            for (int i = 0; i < N; i++) {
                x[i] = in.nextInt();
                y[i] = in.nextInt();
            }

            double lx = 0, hx = 1e8;
            double ly = 0, hy = 1e8;
            while (hx - lx > 1e-9) {
                double llx = (lx * 2 + hx) / 3;
                double hhx = (lx + hx * 2) / 3;

                double lly, hhy;
                double low = 0, hi = 1e8;
                while (hi - low > 1e-9) {
                    double ll = (low * 2 + hi) / 3;
                    double hh = (low + hi * 2) / 3;
                    double temp1 = calc(x, y, llx, ll);
                    double temp2 = calc(x, y, llx, hh);
                    if (temp1 < temp2) {
                        hi = hh;
                    } else {
                        low = ll;
                    }
                }
                lly = hi;

                low = 0;
                hi = 1e8;
                while (hi - low > 1e-9) {
                    double ll = (low * 2 + hi) / 3;
                    double hh = (low + hi * 2) / 3;
                    double temp1 = calc(x, y, hhx, ll);
                    double temp2 = calc(x, y, hhx, hh);
                    if (temp1 < temp2) {
                        hi = hh;
                    } else {
                        low = ll;
                    }
                }
                hhy = hi;

                double temp1 = calc(x, y, llx, lly);
                double temp2 = calc(x, y, hhx, hhy);
                if (temp1 < temp2) {
                    hx = hhx;
                    hy = hhy;
                } else {
                    lx = llx;
                    ly = lly;
                }
            }
            double ret = calc(x, y, hx, hy);
            out.printf("%.6f\n", ret);
        }

        private double calc(int[] x, int[] y, double px, double py) {
            double len = 0;
            for (int i = 0; i < x.length; i++) {
                double temp = Math.sqrt(Math.pow(px - x[i], 2) + Math.pow(py - y[i], 2));
                len = Math.max(len, temp);
            }
            return len;
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

    }
}

