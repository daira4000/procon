import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.stream.IntStream;
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
            boolean ok;
            ok = S.charAt(0) == 'A';
            String substring = S.substring(2, S.length() - 1);
            ok = ok && substring.chars().filter(c -> c == 'C').count() == 1;
            String substring1 = S.substring(0, 2);
            ok = ok && substring1.indexOf('C') == -1;
            String substring2 = S.substring(S.length() - 1);
            ok = ok && substring2.indexOf('C') == -1;
            ok = ok && S.substring(1).chars().filter(c -> c != 'C').filter(c -> 'A' <= c && c <= 'Z').count() == 0;
            out.println(ok ? "AC" : "WA");
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

