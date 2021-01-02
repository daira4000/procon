import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashSet;
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
        int N;
        HashSet<String> set1 = new HashSet<>();
        HashSet<String> set2 = new HashSet<>();

        public void solve(int testNumber, MyScanner in, PrintWriter out) {
            N = in.Int();
            for (int i = 0; i < N; i++) {
                String S = in.next();
                if (S.charAt(0) == '!') {
                    set2.add(S);
                } else {
                    set1.add(S);
                }
            }
            StringBuilder sb = new StringBuilder();
            for (String S : set1) {
                sb.setLength(0);
                sb.append('!').append(S);
                if (set2.contains(sb.toString())) {
                    out.println(S);
                    return;
                }
            }
            out.println("satisfiable");
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

