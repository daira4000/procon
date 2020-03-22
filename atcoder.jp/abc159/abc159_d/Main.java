import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Map;
import java.util.Map.Entry;
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
            int N = in.nextInt();
            int[] A = in.nextIntArray(N);
            Map<Integer, Integer> map = new HashMap<>();
            Map<Integer, Long> a1 = new HashMap<>();
            Map<Integer, Long> a2 = new HashMap<>();
            for (int i = 0; i < N; i++) {
                map.put(A[i], map.getOrDefault(A[i], 0) + 1);
            }
            long sum = 0;
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int n = entry.getKey();
                long c = entry.getValue();
                long comb = c * (c - 1) / 2;
                a1.put(n, comb);
                sum += comb;
                a2.put(n, c > 1 ? (c - 1) * (c - 2) / 2 : 0);
            }
            for (int i = 0; i < N; i++) {
                out.println(sum - a1.get(A[i]) + a2.get(A[i]));
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
                    throw new RuntimeException(e);
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public int[] nextIntArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextInt();
            }
            return a;
        }

    }
}

