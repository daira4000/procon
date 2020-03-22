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
            String S = in.next();
            int N = S.length();
            boolean ans = true;
            String S2 = S.substring(0, (N - 1) / 2);
            String S3 = S.substring((N + 3) / 2 - 1, N);
            for (int i = 0; i < N && ans; i++) {
                ans = S.charAt(i) == S.charAt(N - i - 1);
            }
            N = S2.length();
            for (int i = 0; i < N && ans; i++) {
                ans = S2.charAt(i) == S2.charAt(N - i - 1);
            }
            N = S3.length();
            for (int i = 0; i < N && ans; i++) {
                ans = S3.charAt(i) == S3.charAt(N - i - 1);
            }
            out.println(ans ? "Yes" : "No");
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

    }
}

