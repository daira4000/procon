import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.AbstractMap;
import java.util.TreeMap;
import java.util.StringTokenizer;
import java.util.Map;
import java.util.Map.Entry;
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
            int N = in.nextInt();
            long D = in.nextLong();
            long A = in.nextLong();
            List<F.Monster> list = new ArrayList<>(N);
            long maxX = 0;
            for (int i = 0; i < N; i++) {
                long X = in.nextLong();
                maxX = Math.max(maxX, X);
                long L = in.nextLong();
                list.add(new F.Monster(X, (long) Math.ceil(L / (double) A)));
            }
            list.sort(Comparator.comparingLong(o -> o.X));

            long ans = 0;
            long dmg = 0;
            TreeMap<Long, Long> que = new TreeMap<>();
            for (int i = 0; i < N; i++) {
                F.Monster lm = list.get(i);
                while (!que.isEmpty() && que.firstEntry().getKey() < lm.X) {
                    dmg -= que.pollFirstEntry().getValue();
                }
                long h = lm.H - dmg;
                if (h > 0) {
                    dmg += h;
                    ans += h;
                    long range = lm.X + D * 2;
                    que.put(range, que.getOrDefault(range, 0L) + h);
                }
            }
            out.println(ans);
        }

        static class Monster {
            long X;
            long H;

            Monster(long x, long h) {
                X = x;
                H = h;
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

        public long nextLong() {
            return Long.parseLong(next());
        }

    }
}

