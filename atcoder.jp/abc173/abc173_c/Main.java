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
        C solver = new C();
        solver.solve(1, in, out);
        out.close();
    }

    static class C {
        public void solve(int testNumber, MyScanner in, PrintWriter out) {
            int H = in.Int();
            int W = in.Int();
            int K = in.Int();
            char[][] c = new char[H][W];
            for (int i = 0; i < H; i++) {
                c[i] = in.next().toCharArray();
            }

            int ans = 0;
            int hm = 1 << H;
            int wm = 1 << W;
            for (int h = 0; h < hm; h++) {
                for (int w = 0; w < wm; w++) {
                    int cnt = 0;
                    for (int i = 0; i < H; i++) {
                        if (((1 << i) & h) > 0) continue;
                        for (int j = 0; j < W; j++) {
                            if (((1 << j) & w) > 0) continue;
                            if (c[i][j] == '#') cnt++;
                        }
                    }
                    if (cnt == K) ans++;
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

