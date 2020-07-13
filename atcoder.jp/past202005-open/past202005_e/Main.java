import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Map;
import java.util.HashMap;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
        E solver = new E();
        solver.solve(1, in, out);
        out.close();
    }

    static class E {
        public void solve(int testNumber, MyScanner in, PrintWriter out) {
            int N = in.Int();
            int M = in.Int();
            int Q = in.Int();

            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < N; i++) {
                map.put(i, new ArrayList<>());
            }
            for (int i = 0; i < M; i++) {
                int u = in.Int() - 1;
                int v = in.Int() - 1;
                map.get(u).add(v);
                map.get(v).add(u);
            }

            int[] c = in.Int(N);

            for (int q = 0; q < Q; q++) {
                int t = in.Int();
                if (t == 1) {
                    int x = in.Int() - 1;
                    out.println(c[x]);
                    for (int i : map.get(x)) {
                        c[i] = c[x];
                    }
                } else {
                    int x = in.Int() - 1;
                    int y = in.Int();
                    out.println(c[x]);
                    c[x] = y;
                }
            }
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

        public int[] Int(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Int();
            }
            return a;
        }

    }
}

