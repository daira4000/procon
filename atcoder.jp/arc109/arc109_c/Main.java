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
        int n;
        int k;
        String s;

        public void solve(int testNumber, MyScanner in, PrintWriter out) {
            n = in.Int();
            k = in.Int();
            s = in.next();

            s = s + s;
            n *= 2;
            StringBuilder t = new StringBuilder(n);
            for (int i = 0; i < k; i++) {
                t.setLength(0);
                for (int j = 0; j < n; j += 2) {
                    t.append(judge(s.charAt(j), s.charAt(j + 1)));
                }
                t.append(t);
                s = t.toString();
            }
            out.println(s.charAt(0));
        }

        private char judge(char a, char b) {
            if (a == b) return a;
            if (a == 'R') return b == 'P' ? 'P' : 'R';
            else if (a == 'P') return b == 'S' ? 'S' : 'P';
            else return b == 'R' ? 'R' : 'S';
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

