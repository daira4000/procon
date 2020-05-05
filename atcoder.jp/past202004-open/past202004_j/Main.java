import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.StringTokenizer;
import java.io.IOException;
import java.util.regex.Pattern;
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
        J solver = new J();
        solver.solve(1, in, out);
        out.close();
    }

    static class J {
        public void solve(int testNumber, MyScanner in, PrintWriter out) {
            String S = in.next();
            while (true) {
                String s = S.replaceAll("\\(\\)", "");
                if (s.equals(S)) {
                    break;
                }
                S = s;
            }
            Pattern pattern = Pattern.compile("\\([^\\(\\)]+?\\)");
            while (true) {
                Matcher matcher = pattern.matcher(S);
                if (!matcher.find()) break;
                String group = matcher.group();
                int length = group.length();
                StringBuilder sb = new StringBuilder(group.substring(1, length - 1));
                for (int i = 0; i < length - 2; i++) {
                    sb.append(group.charAt(length - i - 2));
                }
                S = S.replace(group, sb.toString());
            }
            out.println(S);
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

