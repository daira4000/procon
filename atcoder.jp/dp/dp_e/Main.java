import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
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
        E solver = new E();
        solver.solve(1, in, out);
        out.close();
    }

    static class E {
        public void solve(int testNumber, MyScanner in, PrintWriter out) {
            int N = in.nextInt();
            int W = in.nextInt();
            E.Item[] items = new E.Item[N];
            int V = 0;
            for (int i = 0; i < N; i++) {
                items[i] = new E.Item(in.nextInt(), in.nextInt());
                V += items[i].v;
            }

            long[][] sum = new long[N + 1][V + 1];
            long max = (long) 1e15;
            for (int i = 0; i <= N; i++) {
                Arrays.fill(sum[i], max);
                sum[i][0] = 0;
            }
            for (int i = 1; i <= N; i++) {
                E.Item item = items[i - 1];
                for (int j = 0; j <= V; j++) {
                    if (j < item.v) {
                        sum[i][j] = sum[i - 1][j];
                    } else {
                        sum[i][j] = Math.min(sum[i - 1][j], sum[i - 1][j - item.v] + item.w);
                    }
                }
            }
            long ans = 0;
            for (int i = V; i > 0; i--) {
                if (sum[N][i] <= W) {
                    ans = i;
                    break;
                }
            }
            out.println(ans);
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

