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
        B solver = new B();
        solver.solve(1, in, out);
        out.close();
    }

    static class B {
        public void solve(int testNumber, MyScanner in, PrintWriter out) {
            int N = in.Int();
            String S = in.next();

            if (N % 2 == 0) {
                out.println(-1);
                return;
            }
            boolean f = true;
            for (int i = 1; f && i < N; i++) {
                char c1 = S.charAt(i - 1);
                char c2 = S.charAt(i);
                if (c1 == 'a') {
                    f = c2 == 'b';
                } else if (c1 == 'b') {
                    f = c2 == 'c';
                } else if (c1 == 'c') {
                    f = c2 == 'a';
                } else {
                    f = false;
                }
            }
            if (f) {
                f = S.charAt(N / 2) == 'b';
            }
            out.println(f ? N / 2 : -1);
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

