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
        D solver = new D();
        solver.solve(1, in, out);
        out.close();
    }

    static class D {
        public void solve(int testNumber, MyScanner in, PrintWriter out) {
            int N = in.nextInt();
            int W = in.nextInt();
            D.Item[] items = new D.Item[N];
            for (int i = 0; i < N; i++) {
                items[i] = new D.Item(in.nextInt(), in.nextInt());
            }

            long[][] sum = new long[N + 1][W + 1];
            for (int i = 1; i <= N; i++) {
                for (int j = 0; j <= W; j++) {
                    D.Item item = items[i - 1];
                    if (j < item.w) {
                        sum[i][j] = sum[i - 1][j];
                    } else {
                        sum[i][j] = Math.max(sum[i - 1][j - item.w] + item.v, sum[i - 1][j]);
                    }
                }
            }
            out.println(sum[N][W]);
        }

        static class Item {
            int w;
            int v;

            Item(int w, int v) {
                this.w = w;
                this.v = v;
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

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

