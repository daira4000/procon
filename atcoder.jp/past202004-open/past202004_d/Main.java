import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.Set;
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
            String S = in.next();
            Set<String> set = new HashSet<>();
            for (int i = 1; i <= 3; i++) {
                for (int j = 0; j < S.length() - i + 1; j++) {
                    set.add(S.substring(j, j + i));
                }
            }
            int cnt = 0;
            while (cnt != set.size()) {
                cnt = set.size();
                Set<String> set2 = new HashSet<>();
                for (String s : set) {
                    for (int i = 0; i < s.length(); i++) {
                        char[] cs = s.toCharArray();
                        cs[i] = '.';
                        set2.add(new String(cs));
                    }
                }
                set.addAll(set2);
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
                    throw new RuntimeException(e);
                }
            }
            return st.nextToken();
        }

    }
}

