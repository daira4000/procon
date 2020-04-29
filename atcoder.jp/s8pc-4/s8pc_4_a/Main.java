import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.util.Comparator;
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
        A solver = new A();
        solver.solve(1, in, out);
        out.close();
    }

    static class A {
        public void solve(int testNumber, MyScanner in, PrintWriter out) {
            int N = in.Int();
            List<String> S = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                S.add(in.next());
            }
            String T = in.next();

            List<String> al = new ArrayList<>();
            List<String> zl = new ArrayList<>();
            for (String s : S) {
                al.add(s.replace('?', 'a'));
                zl.add(s.replace('?', 'z'));
            }
            al.sort(Comparator.naturalOrder());
            zl.sort(Comparator.naturalOrder());
            int ai = -1;
            int zi = 0;
            for (int i = 0; i < N; i++) {
                if (T.compareTo(al.get(i)) >= 0) {
                    zi = i + 1;
                }
                if (T.compareTo(zl.get(i)) <= 0 && ai == -1) {
                    ai = i;
                }
            }
            if (ai == -1) ai = N;
            StringBuilder sb = new StringBuilder();
            for (int i = ai; i <= zi; i++) {
                sb.append(i + 1).append(' ');
            }
            out.println(sb.subSequence(0, sb.length() - 1));
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

