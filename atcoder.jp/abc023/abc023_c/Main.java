import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Set;
import java.util.HashMap;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
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
        C solver = new C();
        solver.solve(1, in, out);
        out.close();
    }

    static class C {
        public void solve(int testNumber, MyScanner in, PrintWriter out) {
            int R = in.Int();
            int C = in.Int();
            int K = in.Int();
            int N = in.Int();
            int[] r = new int[N];
            int[] c = new int[N];
            Set<C.Pair<Integer, Integer>> set = new HashSet<>();
            for (int i = 0; i < N; i++) {
                r[i] = in.Int() - 1;
                c[i] = in.Int() - 1;
                set.add(new C.Pair<>(r[i], c[i]));
            }

            int[] rs = new int[R];
            for (int i = 0; i < N; i++) {
                rs[r[i]]++;
            }
            int[] cs = new int[C];
            for (int i = 0; i < N; i++) {
                cs[c[i]]++;
            }

            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < C; i++) {
                Integer key = cs[i];
                if (!map.containsKey(key)) {
                    map.put(key, new ArrayList<>());
                }
                map.get(key).add(i);
            }

            long ans = 0;
            for (int i = 0; i < R; i++) {
                int key = K - rs[i];
                if (map.containsKey(key)) {
                    ans += map.get(key).size();
                }
            }
            for (C.Pair<Integer, Integer> p : set) {
                if (rs[p.k] + cs[p.v] == K) {
                    ans -= 1;
                }
                if (rs[p.k] + cs[p.v] == K + 1) {
                    ans += 1;
                }
            }
            out.println(ans);
        }

        static class Pair<K extends Comparable<K>, V extends Comparable<V>> implements Comparable<C.Pair<K, V>> {
            K k;
            V v;

            Pair(K k, V v) {
                this.k = k;
                this.v = v;
            }

            public int compareTo(C.Pair<K, V> o) {
                int c = this.k.compareTo(o.k);
                if (c == 0) c = this.v.compareTo(o.v);
                return c;
            }

            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                C.Pair<?, ?> pair = (C.Pair<?, ?>) o;
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

