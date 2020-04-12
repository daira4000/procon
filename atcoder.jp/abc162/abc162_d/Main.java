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
        D solver = new D();
        solver.solve(1, in, out);
        out.close();
    }

    static class D {
        public void solve(int testNumber, MyScanner in, PrintWriter out) {
            int N = in.Int();
            String S = in.next();
            int[] r = new int[N + 1];
            int[] g = new int[N + 1];
            int[] b = new int[N + 1];
            for (int i = 0; i < N; i++) {
                char c = S.charAt(i);
                r[i + 1] = r[i] + (c == 'R' ? 1 : 0);
                g[i + 1] = g[i] + (c == 'G' ? 1 : 0);
                b[i + 1] = b[i] + (c == 'B' ? 1 : 0);
            }
            long ans = 0;
            for (int i = 0; i < N - 2; i++) {
                for (int j = i + 1; j < N - 1; j++) {
                    char[] cs = new char[]{S.charAt(i), S.charAt(j)};
                    if (cs[0] == cs[1]) continue;
                    Arrays.sort(cs);
                    int[] arr;
                    if (cs[0] == 'B') {
                        if (cs[1] == 'G') {
                            arr = r;
                        } else {
                            arr = g;
                        }
                    } else {
                        arr = b;
                    }
                    if (j - i == 1) {
                        ans += (arr[N] - arr[j + 2]);
                    } else {
                        int idx = Math.min(N, j + (j - i));
                        ans += (arr[idx] - arr[j]);
                        int idx2 = j + 1 + (j - i);
                        if (idx2 <= N)
                            ans += (arr[N] - arr[idx2]);
                    }
                }
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

