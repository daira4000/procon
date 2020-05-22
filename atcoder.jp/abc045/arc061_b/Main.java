import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.Map;
import java.util.Map.Entry;
import java.util.HashMap;
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
        arc061_b solver = new arc061_b();
        solver.solve(1, in, out);
        out.close();
    }

    static class arc061_b {
        public void solve(int testNumber, MyScanner in, PrintWriter out) {
            int H = in.Int();
            int W = in.Int();
            int N = in.Int();

            Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
            for (int n = 0; n < N; n++) {
                int a = in.Int() - 1;
                int b = in.Int() - 1;
                for (int i = 0; i < 3; i++) {
                    if (a - i < 0) continue;
                    if (a - i >= H - 2) continue;
                    for (int j = 0; j < 3; j++) {
                        if (b - j < 0) continue;
                        if (b - j >= W - 2) continue;
                        int x = a - i;
                        int y = b - j;
                        if (!map.containsKey(x)) {
                            map.put(x, new HashMap<>());
                        }
                        Map<Integer, Integer> map1 = map.get(x);
                        map1.put(y, map1.getOrDefault(y, 0) + 1);
                    }
                }
            }
            long[] ans = new long[10];
            long sum = 0;
            for (Map.Entry<Integer, Map<Integer, Integer>> e : map.entrySet()) {
                for (Map.Entry<Integer, Integer> ee : e.getValue().entrySet()) {
                    ans[ee.getValue()]++;
                }
                sum += e.getValue().size();
            }
            ans[0] = (H - 2L) * (W - 2L) - sum;
            for (int i = 0; i < 10; i++) {
                out.println(ans[i]);
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

