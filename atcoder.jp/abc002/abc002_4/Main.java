import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Set;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
        D solver = new D();
        solver.solve(1, in, out);
        out.close();
    }

    static class D {
        public void solve(int testNumber, MyScanner in, PrintWriter out) {
            int N = in.Int();
            List<D.P> list = new ArrayList<>(N);
            for (int i = 0; i < N; i++) {
                list.add(new D.P());
                list.get(i).set.add(i);
            }
            int M = in.Int();
            for (int i = 0; i < M; i++) {
                int x = in.Int() - 1;
                int y = in.Int() - 1;
                list.get(x).set.add(y);
                list.get(y).set.add(x);
            }

            int ans = 1;
            int max = 1 << N;
            Set<Integer> set = new HashSet<>();
            for (int i = 1; i < max; i++) {
                set.clear();
                for (int j = 0; j < N; j++) {
                    if ((i >> j & 1) == 1) {
                        set.add(j);
                    }
                }
                boolean f = true;
                for (int j : set) {
                    if (!list.get(j).set.containsAll(set)) {
                        f = false;
                        break;
                    }
                }
                if (f) {
                    ans = Math.max(ans, set.size());
                }
            }
            out.println(ans);
        }

        static class P {
            Set<Integer> set = new HashSet<>();

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

