import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.HashMap;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Stream;
import java.util.StringTokenizer;
import java.util.Optional;
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
        D solver = new D();
        solver.solve(1, in, out);
        out.close();
    }

    static class D {
        public void solve(int testNumber, MyScanner in, PrintWriter out) {
            int N = in.nextInt();

            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 2; i <= N; i++) {
                int M = i;
                for (int j = 2; j <= M; j++) {
                    while (M >= j) {
                        if (M % j > 0) {
                            break;
                        }
                        map.put(j, map.getOrDefault(j, 0) + 1);
                        M /= j;
                    }
                }
                if (M > 1) {
                    map.put(M, map.getOrDefault(M, 0) + 1);
                }
            }

            int max = map.keySet().stream().max(Comparator.naturalOrder()).orElse(0);
            int cnt = 0;
            for (int i = 2; i <= max; i++) {
                int p = map.getOrDefault(i, 0);
                if (p >= 74) {
                    cnt++;
                }
            }
            for (int i = 2; i <= max; i++) {
                for (int j = 2; j <= max; j++) {
                    if (i == j) continue;
                    int p = map.getOrDefault(i, 0);
                    int q = map.getOrDefault(j, 0);

                    if (p >= 24 && q >= 2) {
                        cnt++;
                    }
                    if (p >= 14 && q >= 4) {
                        cnt++;
                    }
                }
            }
            for (int i = 2; i <= max; i++) {
                for (int j = i + 1; j <= max; j++) {
                    if (i == j) continue;
                    for (int k = 2; k <= max; k++) {
                        if (i == k || j == k) continue;
                        int p = map.getOrDefault(i, 0);
                        int q = map.getOrDefault(j, 0);
                        int r = map.getOrDefault(k, 0);

                        if (p >= 4 && q >= 4 && r >= 2) {
                            cnt++;
                        }
                    }
                }
            }

            out.println(cnt);
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

