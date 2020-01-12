import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Collection;
import java.io.IOException;
import java.util.Deque;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.util.ArrayDeque;
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
            char[][] S = new char[H][W];
            for (int i = 0; i < H; i++) {
                S[i] = in.next().toCharArray();
            }

            int sx = -1, sy = -1;
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if (S[i][j] == '.') {
                        sy = i;
                        sx = j;
                        break;
                    }
                }
                if (sx >= 0) {
                    break;
                }
            }

            int max = 0;
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if (S[i][j] == '#') continue;
                    int[] ret = calc(S, j, i);
                    max = Math.max(max, ret[2] - 1);
                }
            }
            out.println(max);
        }

        private int[] calc(char[][] S, int sx, int sy) {
            int H = S.length;
            int W = S[0].length;
            int[][] cnt = new int[H][W];
            cnt[sy][sx] = 1;
            Deque<int[]> que = new ArrayDeque<>();
            que.add(new int[]{sx, sy});
            while (!que.isEmpty()) {
                int[] s = que.removeFirst();
                if (s[0] > 0 && cnt[s[1]][s[0] - 1] == 0 && S[s[1]][s[0] - 1] == '.') {
                    cnt[s[1]][s[0] - 1] = cnt[s[1]][s[0]] + 1;
                    que.add(new int[]{s[0] - 1, s[1]});
                }
                if (s[0] < W - 1 && cnt[s[1]][s[0] + 1] == 0 && S[s[1]][s[0] + 1] == '.') {
                    cnt[s[1]][s[0] + 1] = cnt[s[1]][s[0]] + 1;
                    que.add(new int[]{s[0] + 1, s[1]});
                }
                if (s[1] > 0 && cnt[s[1] - 1][s[0]] == 0 && S[s[1] - 1][s[0]] == '.') {
                    cnt[s[1] - 1][s[0]] = cnt[s[1]][s[0]] + 1;
                    que.add(new int[]{s[0], s[1] - 1});
                }
                if (s[1] < H - 1 && cnt[s[1] + 1][s[0]] == 0 && S[s[1] + 1][s[0]] == '.') {
                    cnt[s[1] + 1][s[0]] = cnt[s[1]][s[0]] + 1;
                    que.add(new int[]{s[0], s[1] + 1});
                }
            }

            int[] ret = new int[3];
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if (ret[2] < cnt[i][j]) {
                        ret[0] = j;
                        ret[1] = i;
                        ret[2] = cnt[i][j];
                    }
                }
            }
            return ret;
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

