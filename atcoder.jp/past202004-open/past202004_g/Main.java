import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.stream.LongStream;
import java.util.Collection;
import java.util.HashMap;
import java.io.IOException;
import java.util.Deque;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.stream.Stream;
import java.util.StringTokenizer;
import java.util.Map;
import java.io.BufferedReader;
import java.util.LinkedList;
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
            String S = "";
            int Q = in.Int();
            Deque<G.Pair<Integer, Character>> que = new LinkedList<>();
            for (int q = 0; q < Q; q++) {
                int T = in.Int();
                if (T == 1) {
                    String C = in.next();
                    int X = in.Int();
                    que.add(new G.Pair<>(X, C.charAt(0)));
                } else if (T == 2) {
                    int D = in.Int();
                    Map<Character, Integer> map = new HashMap<>();
                    while (D > 0 && !que.isEmpty()) {
                        G.Pair<Integer, Character> p = que.getFirst();
                        if (p.k > D) {
                            p.k -= D;
                            map.put(p.v, map.getOrDefault(p.v, 0) + D);
                            D = 0;
                        } else {
                            que.poll();
                            D -= p.k;
                            map.put(p.v, map.getOrDefault(p.v, 0) + p.k);
                        }
                    }
                    long cnt = map.values().stream().mapToLong(v -> (long) v * v).sum();
                    out.println(cnt);
                }
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

