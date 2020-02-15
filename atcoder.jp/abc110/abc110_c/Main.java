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
            String S = in.next();
            String T = in.next();

            int len = S.length();
            char[] scs = new char['z' - 'a' + 1];
            char[] tcs = new char['z' - 'a' + 1];
            for (int i = 0; i < len; i++) {
                char sa = S.charAt(i);
                char ta = T.charAt(i);
                int si = sa - 'a';
                int ti = ta - 'a';
                if (scs[ti] == 0) {
                    scs[ti] = sa;
                }
                if (tcs[si] == 0) {
                    tcs[si] = ta;
                }
                if (scs[ti] != sa || tcs[si] != ta) {
                    out.println("No");
                    return;
                }
            }
            out.println("Yes");
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

