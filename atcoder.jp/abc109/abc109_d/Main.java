import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
            int H = in.nextInt();
            int W = in.nextInt();
            int[][] a = in.nextIntArray(H, W);
            List<String> ans = new ArrayList<>();
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W - 1; j++) {
                    if (a[i][j] % 2 == 1) {
                        ans.add(String.format("%d %d %d %d", i + 1, j + 1, i + 1, j + 2));
                        a[i][j]--;
                        a[i][j + 1]++;
                    }
                }
            }
            for (int i = 0; i < H - 1; i++) {
                if (a[i][W - 1] % 2 == 1) {
                    ans.add(String.format("%d %d %d %d", i + 1, W, i + 2, W));
                    a[i][W - 1]--;
                    a[i + 1][W - 1]++;
                }
            }
            out.println(ans.size());
            ans.forEach(out::println);
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

        public int[][] nextIntArray(int n, int m) {
            int[][] a = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    a[i][j] = nextInt();
                }
            }
            return a;
        }

    }
}

