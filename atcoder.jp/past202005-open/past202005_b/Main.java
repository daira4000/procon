import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Map;
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
        B solver = new B();
        solver.solve(1, in, out);
        out.close();
    }

    static class B {
        public void solve(int testNumber, MyScanner in, PrintWriter out) {
            int N = in.Int();
            int M = in.Int();
            int Q = in.Int();

            int[] qs = new int[M];
            Arrays.fill(qs, N);

            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < Q; i++) {
                int t = in.Int();
                if (t == 1) {
                    int n = in.Int();
                    int score = 0;
                    if (map.containsKey(n)) {
                        for (int m : map.get(n)) {
                            score += qs[m];
                        }
                    }
                    out.println(score);
                } else {
                    int n = in.Int();
                    int m = in.Int() - 1;
                    if (!map.containsKey(n)) {
                        map.put(n, new ArrayList<>());
                    }
                    map.get(n).add(m);
                    qs[m]--;
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

    }
}

