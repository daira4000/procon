import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.Collection;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.Deque;
import java.util.LinkedList;
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
            int H = in.Int();
            int W = in.Int();
            int[][] s = new int[H][W];
            int inf = 1 << 30;
            for (int i = 0; i < H; i++) {
                char[] cs = in.next().toCharArray();
                for (int j = 0; j < W; j++) {
                    s[i][j] = cs[j] == '.' ? inf : -1;
                }
            }

            int[][] moves = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
            Deque<int[]> que = new LinkedList<>();
            que.add(new int[]{0, 0, 0});
            while (!que.isEmpty()) {
                int[] q = que.poll();
                int x = q[0];
                int y = q[1];
                int c = q[2];
                if (s[y][x] < 0) {
                    continue;
                }
                if (s[y][x] <= c) {
                    continue;
                }
                s[y][x] = c;
                for (int[] move : moves) {
                    int x2 = x + move[0];
                    int y2 = y + move[1];
                    if (x2 < 0 || y2 < 0 || W <= x2 || H <= y2) {
                        continue;
                    }
                    que.add(new int[]{x2, y2, c + 1});
                }
            }

            if (s[H - 1][W - 1] == inf) {
                out.println(-1);
                return;
            }
            int cnt = -s[H - 1][W - 1] - 1;
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if (s[i][j] >= 0) {
                        cnt++;
                    }
                }
            }
            out.println(cnt);
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
                    return null;
                }
            }
            return st.nextToken();
        }

        public int Int() {
            return Integer.parseInt(next());
        }

    }
}

