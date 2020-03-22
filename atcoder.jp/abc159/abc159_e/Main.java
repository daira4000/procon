import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.io.IOException;
import java.util.function.Function;
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
            int H = in.nextInt();
            int W = in.nextInt();
            int K = in.nextInt();
            char[][] S = new char[H][W];
            for (int i = 0; i < H; i++) {
                S[i] = in.next().toCharArray();
            }

            int INF = 1000000000;
            int ans = INF;
            for (int h = 0; h < (1 << H); h++) {
                int g = 0;
                int[] id = new int[H];
                for (int i = 0; i < H; i++) {
                    id[i] = g;
                    if ((h >> i & 1) == 1) {
                        g++;
                    }
                }

                int[] c = new int[g + 1];
                Function<Integer, Boolean> add = (i) -> {
                    for (int j = 0; j < H; j++) {
                        c[id[j]] += S[j][i] - '0';
                        if (c[id[j]] > K) return false;
                    }
                    return true;
                };
                int cnt = g;
                for (int i = 0; i < W; i++) {
                    if (!add.apply(i)) {
                        Arrays.fill(c, 0);
                        cnt++;
                        if (!add.apply(i)) {
                            cnt = INF;
                            break;
                        }
                    }
                }
                ans = Math.min(ans, cnt);
            }
            out.println(ans == INF ? 0 : ans);
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

