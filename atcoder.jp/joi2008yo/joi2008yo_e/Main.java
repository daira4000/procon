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
        E solver = new E();
        solver.solve(1, in, out);
        out.close();
    }

    static class E {
        public void solve(int testNumber, MyScanner in, PrintWriter out) {
            int R = in.Int();
            int C = in.Int();
            int[][] a = new int[R][];
            for (int i = 0; i < R; i++) {
                a[i] = in.Int(C);
            }

            int max = 0;
            int rm = 1 << R;
            for (int b = 0; b < rm; b++) {
                int cnt = 0;
                for (int i = 0; i < C; i++) {
                    int tmp = 0;
                    for (int j = 0; j < R; j++) {
                        int x = a[j][i];
                        if (((b >> j) & 1) == 0) {
                            x = 1 - x;
                        }
                        tmp += 1 - x;
                    }
                    cnt += Math.max(R - tmp, tmp);
                }
                max = Math.max(max, cnt);
            }
            out.println(max);
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

        public int[] Int(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Int();
            }
            return a;
        }

    }
}

