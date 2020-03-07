import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collection;
import java.io.IOException;
import java.util.stream.Collectors;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Stream;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.util.LinkedList;
import java.util.Collections;
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
            List<String> list = new LinkedList<>();
            list.addAll(Arrays.stream(S.split("")).collect(Collectors.toList()));
            int Q = in.nextInt();
            boolean rev = false;
            for (int i = 0; i < Q; i++) {
                int T = in.nextInt();
                if (T == 1) {
                    rev = !rev;
                } else {
                    int F = in.nextInt();
                    String C = in.next();
                    if (!rev) {
                        if (F == 1) {
                            list.add(0, C);
                        } else {
                            list.add(C);
                        }
                    } else {
                        if (F == 1) {
                            list.add(C);
                        } else {
                            list.add(0, C);
                        }
                    }
                }
            }
            if (rev) {
                Collections.reverse(list);
            }
            out.println(list.stream().collect(Collectors.joining()));
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

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

