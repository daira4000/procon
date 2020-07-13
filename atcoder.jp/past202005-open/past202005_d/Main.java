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
            int N = in.Int();
            char[][] ss = new char[5][N];
            for (int i = 0; i < 5; i++) {
                ss[i] = in.next().toCharArray();
            }
            int[][][] ps = new int[][][]{
                    {{1, 1, 1}, {1, 3, 1}, {2, 2, 0}, {3, 1, 1}, {3, 3, 1}},
                    {{1, 2, 1}, {3, 2, 1}},
                    {{1, 1, 0}, {1, 3, 1}, {3, 1, 1}},
                    {{1, 1, 0}, {1, 3, 1}, {3, 1, 0}, {3, 3, 1}, {2, 2, 1}},
                    {{0, 2, 0}},
                    {{1, 1, 1}, {1, 3, 0}, {2, 2, 1}, {3, 1, 0}, {3, 3, 1}},
                    {{1, 1, 1}, {1, 3, 0}, {2, 2, 1}, {3, 1, 1}, {3, 3, 1}},
                    {{2, 1, 0}, {4, 1, 0}},
                    {{1, 1, 1}, {1, 3, 1}, {2, 2, 1}, {3, 1, 1}, {3, 3, 1}},
                    {{1, 1, 1}, {1, 3, 1}, {2, 2, 1}, {3, 1, 0}, {3, 3, 1}}
            };

            StringBuilder sb = new StringBuilder(N);
            for (int n = 0; n < N; n++) {
                for (int c = 0; c < 10; c++) {
                    boolean f = true;
                    for (int i = 0; i < ps[c].length; i++) {
                        int[] p = ps[c][i];
                        int y = p[0];
                        int x = 4 * n + p[1];
                        if (ss[y][x] != (p[2] == 1 ? '#' : '.')) {
                            f = false;
                            break;
                        }
                    }
                    if (f) {
                        sb.append(c);
                        break;
                    }
                }
            }
            out.println(sb.toString());
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

