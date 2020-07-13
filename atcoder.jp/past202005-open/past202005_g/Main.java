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
import java.util.HashSet;
import java.util.Objects;
import java.util.StringTokenizer;
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
        G solver = new G();
        solver.solve(1, in, out);
        out.close();
    }

    static class G {
        public void solve(int testNumber, MyScanner in, PrintWriter out) {
            int N = in.Int();
            int X = in.Int();
            int Y = in.Int();

            G.Pair<Integer, Integer> goal = new G.Pair<>(X, Y);

            Set<G.Pair<Integer, Integer>> walls = new HashSet<>();
            for (int i = 0; i < N; i++) {
                walls.add(new G.Pair<>(in.Int(), in.Int()));
            }

            int[][] mvs = new int[][]{{1, 1}, {0, 1}, {-1, 1}, {1, 0}, {-1, 0}, {0, -1}};
            HashMap<G.Pair<Integer, Integer>, Integer> costs = new HashMap<>();
            Deque<G.Pair<Integer, Integer>> que = new ArrayDeque<>();
            G.Pair<Integer, Integer> p0 = new G.Pair<>(0, 0);
            costs.put(p0, 0);
            que.add(p0);
            while (!que.isEmpty()) {
                G.Pair<Integer, Integer> p = que.poll();
                if (p.equals(goal)) break;
                int c = costs.get(p);
                for (int[] mv : mvs) {
                    int x = p.k + mv[0];
                    int y = p.v + mv[1];
                    if (Math.abs(x) > 201 || Math.abs(y) > 201) {
                        continue;
                    }
                    G.Pair<Integer, Integer> p2 = new G.Pair<>(x, y);
                    if (walls.contains(p2)) {
                        continue;
                    }
                    if (costs.containsKey(p2) && costs.get(p2) <= c + 1) {
                        continue;
                    }
                    costs.put(p2, c + 1);
                    que.add(p2);
                }
            }
            if (costs.containsKey(goal)) {
                out.println(costs.get(goal));
            } else {
                out.println(-1);
            }
        }

        static class Pair<K extends Comparable<K>, V extends Comparable<V>> implements Comparable<G.Pair<K, V>> {
            K k;
            V v;

            Pair(K k, V v) {
                this.k = k;
                this.v = v;
            }

            public int compareTo(G.Pair<K, V> o) {
                int c = this.k.compareTo(o.k);
                if (c == 0) c = this.v.compareTo(o.v);
                return c;
            }

            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                G.Pair<?, ?> pair = (G.Pair<?, ?>) o;
                return Objects.equals(k, pair.k) &&
                        Objects.equals(v, pair.v);
            }

            public int hashCode() {
                return Objects.hash(k, v);
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

