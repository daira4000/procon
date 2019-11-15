import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collection;
import java.io.IOException;
import java.util.stream.Collectors;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import java.util.StringTokenizer;
import java.io.BufferedReader;
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
            long N = in.nextLong();

            List<Long> l753 = new ArrayList<>(Arrays.asList(3L, 5L, 7L));
            gen(l753, 1);
            l753 = l753.stream()
                    .distinct()
                    .map(String::valueOf)
                    .filter(s -> s.indexOf('3') >= 0)
                    .filter(s -> s.indexOf('5') >= 0)
                    .filter(s -> s.indexOf('7') >= 0)
                    .map(Long::valueOf)
                    .filter(l -> l <= N)
                    .collect(Collectors.toList());
            out.println(l753.size());
        }

        private void gen(List<Long> l753, int l) {
            if (l >= 10) return;

            int len = l753.size();
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < 3; j++) {
                    l753.add(l753.get(i) * 10 + 3 + j * 2);
                }
            }
            gen(l753, l + 1);
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

        public long nextLong() {
            return Long.parseLong(next());
        }

    }
}

