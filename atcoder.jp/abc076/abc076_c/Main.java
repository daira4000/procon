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
        abc076_c solver = new abc076_c();
        solver.solve(1, in, out);
        out.close();
    }

    static class abc076_c {
        public void solve(int testNumber, MyScanner in, PrintWriter out) {
            String S = in.next();
            String T = in.next();

            String ans = "UNRESTORABLE";
            int sl = S.length();
            int tl = T.length();
            int idx = -1;
            for (int i = 0; i <= sl - tl; i++) {
                String s = S.substring(i, i + tl);
                boolean f = true;
                for (int j = 0; j < tl; j++) {
                    char c1 = s.charAt(j);
                    char c2 = T.charAt(j);
                    if (c1 != '?' && c1 != c2) {
                        f = false;
                        break;
                    }
                }
                if (f) {
                    idx = i;
                }
            }
            if (idx < 0) {
                out.println(ans);
                return;
            }
            StringBuilder sb = new StringBuilder(S);
            sb.replace(idx, idx + tl, T);
            out.println(sb.toString().replace('?', 'a'));
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

    }
}

