import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Set;
import java.util.HashMap;
import java.io.IOException;
import java.util.Deque;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Map;
import java.io.BufferedReader;
import java.util.ArrayDeque;
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
            int X = in.nextInt();
            int Y = in.nextInt();

            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int i = 0; i <= N; i++) {
                map.put(i, new ArrayList<>());
            }
            for (int i = 1; i < N; i++) {
                map.get(i).add(i + 1);
                map.get(i + 1).add(i);
            }
            map.get(X).add(Y);
            map.get(Y).add(X);

            Set<Integer> set = new HashSet<>();
            Deque<D.Pair> que = new ArrayDeque<>();
            Map<Integer, Integer> cache = new HashMap<>();
            for (int i = 1; i < N; i++) {
                set.clear();
                D.Pair p = new D.Pair(i, 0);
                que.add(p);
                while (!que.isEmpty()) {
                    p = que.removeFirst();
                    if (set.contains(p.x)) continue;
                    set.add(p.x);
                    if (!map.containsKey(p.x)) continue;
                    if (i < p.x) {
                        cache.put(p.y, cache.getOrDefault(p.y, 0) + 1);
                    }
                    for (Integer n : map.get(p.x)) {
                        D.Pair q = new D.Pair(n, p.y + 1);
                        que.add(q);
                    }
                }
            }
            for (int k = 1; k < N; k++) {
                out.println(cache.getOrDefault(k, 0));
            }
        }

        static class Pair {
            int x;
            int y;

            Pair(int a, int b) {
                this.x = a;
                this.y = b;
            }

            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                D.Pair pair = (D.Pair) o;
                return x == pair.x &&
                        y == pair.y;
            }

            public int hashCode() {
                return Objects.hash(x, y);
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

    }
}

