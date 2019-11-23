import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.stream.IntStream;
import java.util.Arrays;
import java.io.IOException;
import java.util.stream.Collectors;
import java.io.InputStreamReader;
import java.util.stream.Stream;
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
        C solver = new C();
        solver.solve(1, in, out);
        out.close();
    }

    static class C {
        public void solve(int testNumber, MyScanner in, PrintWriter out) {
            int H = in.nextInt();
            int W = in.nextInt();
            int K = in.nextInt();
            char[][] s = new char[H][W];
            int[][] ans = new int[H][W];
            for (int i = 0; i < H; i++) {
                s[i] = in.next().toCharArray();
            }

            int peace = 1;
            for (int i = 0; i < H; i++) {
                boolean e = false;
                for (int j = 0; j < W; j++) {
                    if (s[i][j] == '#') {
                        e = true;
                        break;
                    }
                }
                if (e) {
                    e = false;
                    for (int j = 0; j < W; j++) {
                        if (s[i][j] == '#') {
                            if (e) {
                                peace++;
                            } else {
                                e = true;
                            }
                        }
                        ans[i][j] = peace;
                    }
                    peace++;
                }
            }
            for (int i = 0; i < H; i++) {
                if (ans[i][0] == 0) {
                    if (!cp(ans, i, 1)) {
                        cp(ans, H - 1, -1);
                        break;
                    }
                }
            }
            out.println(
                    Arrays.stream(ans)
                            .map(xs -> Arrays.stream(xs)
                                    .mapToObj(String::valueOf)
                                    .collect(Collectors.joining(" ")))
                            .collect(Collectors.joining("\n")));
        }

        private boolean cp(int[][] ans, int dest, int d) {
            if (ans.length <= dest + d) {
                return false;
            }
            if (ans[dest + d][0] == 0) {
                cp(ans, dest + d, d);
            }
            System.arraycopy(ans[dest + d], 0, ans[dest], 0, ans[dest].length);
            return true;
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

