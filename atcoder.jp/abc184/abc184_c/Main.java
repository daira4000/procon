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
        int r1;
        int c1;
        int r2;
        int c2;

        public void solve(int testNumber, MyScanner in, PrintWriter out) {
            r1 = in.Int();
            c1 = in.Int();
            r2 = in.Int();
            c2 = in.Int();

            int cnt = 0;
            while (r1 != r2 || c1 != c2) {
                if (r1 + c1 == r2 + c2 || r1 - c1 == r2 - c2 || Math.abs(r1 - r2) + Math.abs(c1 - c2) <= 3) {
                    r1 = r2;
                    c1 = c2;
                } else {
                    int d = (Math.abs(r1 - r2) + Math.abs(c1 - c2)) / 2;
                    r1 += d * (r1 <= r2 ? 1 : -1);
                    c1 += d * (c1 <= c2 ? 1 : -1);
                }
                cnt++;
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

