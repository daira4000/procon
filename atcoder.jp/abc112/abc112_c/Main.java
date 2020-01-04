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
        public void solve(int testNumber, MyScanner in, PrintWriter out) {
            int N = in.nextInt();
            int[] x = new int[N];
            int[] y = new int[N];
            int[] h = new int[N];
            int[] base = new int[3];
            for (int i = 0; i < N; i++) {
                x[i] = in.nextInt();
                y[i] = in.nextInt();
                h[i] = in.nextInt();
                if (h[i] > 0) {
                    base[0] = x[i];
                    base[1] = y[i];
                    base[2] = h[i];
                }
            }

            int cx = 0, cy = 0, H = 0;
            for (int i = 0; i <= 100; i++) {
                for (int j = 0; j <= 100; j++) {
                    int hi = base[2] + Math.abs(base[0] - j) + Math.abs(base[1] - i);
                    if (H >= hi) {
                        continue;
                    }
                    boolean flag = true;
                    for (int n = 0; n < N; n++) {
                        int temp = Math.max(hi - Math.abs(x[n] - j) - Math.abs(y[n] - i), 0);
                        if (temp != h[n]) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) {
                        cx = j;
                        cy = i;
                        H = hi;
                    }
                }
            }
            out.printf("%d %d %d\n", cx, cy, H);
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

