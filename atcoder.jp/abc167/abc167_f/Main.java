import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Objects;
import java.util.List;
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
        F solver = new F();
        solver.solve(1, in, out);
        out.close();
    }

    static class F {
        public void solve(int testNumber, MyScanner in, PrintWriter out) {
            int N = in.Int();
            List<F.Pair<Integer, Integer>> over = new ArrayList<>();
            List<F.Pair<Integer, Integer>> under = new ArrayList<>();
            long lc = 0, rc = 0;
            for (int i = 0; i < N; i++) {
                String s = in.next();
                String t = null;
                while (true) {
                    t = s.replaceAll("\\(\\)", "");
                    if (s.equals(t)) {
                        break;
                    }
                    s = t;
                }
                if (s.isEmpty()) continue;
                int r = 0, l = 0;
                int len = s.length();
                while (r < len && s.charAt(r) == ')') {
                    r++;
                }
                while (l < len && s.charAt(s.length() - l - 1) == '(') {
                    l++;
                }
                if (l == 0) {
                    rc += r;
                } else if (r == 0) {
                    lc += l;
                } else {
                    if (l >= r) {
                        over.add(new F.Pair<>(l, r));
                    } else {
                        under.add(new F.Pair<>(r, l));
                    }
                }
            }
            Comparator<F.Pair<Integer, Integer>> pairComparator = (o1, o2) -> {
                int c = Integer.compare(o1.v, o2.v);
                if (c == 0) c = Integer.compare(o2.k - o2.v, o1.k - o1.v);
                return c;
            };
            over.sort(pairComparator);
            under.sort(pairComparator);

            long cntl = lc;
            for (F.Pair<Integer, Integer> p : over) {
                cntl -= p.v;
                if (cntl < 0) {
                    out.println("No");
                    return;
                }
                cntl += p.k;
            }
            long cntr = rc;
            for (F.Pair<Integer, Integer> p : under) {
                cntr -= p.v;
                if (cntr < 0) {
                    out.println("No");
                    return;
                }
                cntr += p.k;
            }
            out.println(cntr == cntl ? "Yes" : "No");
        }

        static class Pair<K extends Comparable<K>, V extends Comparable<V>> implements Comparable<F.Pair<K, V>> {
            K k;
            V v;

            Pair(K k, V v) {
                this.k = k;
                this.v = v;
            }

            public int compareTo(F.Pair<K, V> o) {
                int c = this.k.compareTo(o.k);
                if (c == 0) c = this.v.compareTo(o.v);
                return c;
            }

            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                F.Pair<?, ?> pair = (F.Pair<?, ?>) o;
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

