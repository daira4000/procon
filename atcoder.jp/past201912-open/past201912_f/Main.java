import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Collection;
import java.io.IOException;
import java.util.stream.Collectors;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.stream.Stream;
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
        F solver = new F();
        solver.solve(1, in, out);
        out.close();
    }

    static class F {
        public void solve(int testNumber, MyScanner in, PrintWriter out) {
            String S = in.next();
            ArrayList<String> list = new ArrayList<>();
            boolean s = false;
            int length = S.length();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < length; i++) {
                char c = S.charAt(i);
                sb.append(c);
                if ('A' <= c && c <= 'Z') {
                    if (s) {
                        // end
                        list.add(sb.toString());
                        sb.setLength(0);
                        s = false;
                    } else {
                        s = true;
                    }
                }
            }
            if (sb.length() > 0) {
                throw new RuntimeException(sb.toString());
            }
            list.sort(Comparator.comparing(String::toUpperCase));
            out.println(list.stream().map(String::toString).collect(Collectors.joining()));
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

