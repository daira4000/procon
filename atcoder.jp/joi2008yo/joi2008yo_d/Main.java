import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.Comparator;
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
            int m = in.Int();
            int[][] mp = new int[m][2];
            for (int i = 0; i < m; i++) {
                mp[i][0] = in.Int();
                mp[i][1] = in.Int();
            }
            int n = in.Int();
            int[][] np = new int[n][2];
            for (int i = 0; i < n; i++) {
                np[i][0] = in.Int();
                np[i][1] = in.Int();
            }
            Comparator<int[]> comparator = Comparator.comparingInt((int[] o) -> o[0]).thenComparingInt(o -> o[1]);
            Arrays.sort(mp, comparator);
            Arrays.sort(np, comparator);

            for (int i = 0; i < n; i++) {
                int x = np[i][0];
                int y = np[i][1];
                int idx = i;
                boolean f1 = true;
                for (int j = 1; j < m; j++) {
                    int dx = mp[j - 1][0] - mp[j][0];
                    int dy = mp[j - 1][1] - mp[j][1];
                    boolean f2 = false;
                    for (int k = idx + 1; k < n; k++) {
                        int i1 = x - np[k][0];
                        int i2 = y - np[k][1];
                        if (dx == i1 && dy == i2) {
                            f2 = true;
                            x = np[k][0];
                            y = np[k][1];
                            idx = k;
                            break;
                        }
                    }
                    if (!f2) {
                        f1 = false;
                        break;
                    }
                }
                if (f1) {
                    out.printf("%d %d\n", -(mp[0][0] - np[i][0]), -(mp[0][1] - np[i][1]));
                    break;
                }
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

    }
}

