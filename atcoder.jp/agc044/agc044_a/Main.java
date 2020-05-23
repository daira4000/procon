import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.HashMap;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.AbstractCollection;
import java.util.StringTokenizer;
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
        A solver = new A();
        solver.solve(1, in, out);
        out.close();
    }

    static class A {
        public void solve(int testNumber, MyScanner in, PrintWriter out) {
            int T = in.Int();
            HashMap<Long, Long> map = new HashMap<>();
            PriorityQueue<A.Pair<Long, Long>> que = new PriorityQueue<>(Comparator.comparingLong(o -> o.v));
            for (int t = 0; t < T; t++) {
                long N = in.Long();
                long A = in.Long();
                long B = in.Long();
                long C = in.Long();
                long D = in.Long();

                map.clear();
                que.clear();
                que.add(new A.Pair<>(N, 0L));
                long[] mul = new long[]{2, 3, 5};
                long[] cost = new long[]{A, B, C};
                while (!que.isEmpty()) {
                    A.Pair<Long, Long> q = que.poll();
                    long pos = q.k;
                    long cos = q.v;
                    if (map.containsKey(pos) && map.get(pos) <= cos) {
                        continue;
                    }
                    map.put(pos, cos);
                    double b = cos + (double) pos * D;
                    if (b < map.getOrDefault(0L, Long.MAX_VALUE)) {
                        // que.add(new Pair<>(0L, (long) b));
                        map.put(0L, (long) b);
                    }
                    for (int i = 0; i < 3; i++) {
                        long mod = pos % mul[i];
                        if (mod == 0) {
                            long p = pos / mul[i];
                            long c = cos + cost[i];
                            que.add(new A.Pair<>(p, c));
                        } else {
                            A.Pair<Long, Long> e = new A.Pair<>((pos - mod) / mul[i], cos + cost[i] + mod * D);
                            que.add(e);
                            A.Pair<Long, Long> e1 = new A.Pair<>((pos + (mul[i] - mod)) / mul[i], cos + cost[i] + (mul[i] - mod) * D);
                            que.add(e1);
                        }
                    }
                }

                out.println(map.get(0L));
            }
        }

        static class Pair<K extends Comparable<K>, V extends Comparable<V>> implements Comparable<A.Pair<K, V>> {
            K k;
            V v;

            Pair(K k, V v) {
                this.k = k;
                this.v = v;
            }

            public int compareTo(A.Pair<K, V> o) {
                int c = this.k.compareTo(o.k);
                if (c == 0) c = this.v.compareTo(o.v);
                return c;
            }

            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                A.Pair<?, ?> pair = (A.Pair<?, ?>) o;
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

        public long Long() {
            return Long.parseLong(next());
        }

    }
}

