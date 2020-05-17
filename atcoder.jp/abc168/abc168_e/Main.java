import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Set;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;
import java.util.Objects;
import java.util.TreeMap;
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
        E solver = new E();
        solver.solve(1, in, out);
        out.close();
    }

    static class E {
        static long MOD = 1000000007;

        public void solve(int testNumber, MyScanner in, PrintWriter out) {
            int N = in.Int();
            long[] A = new long[N];
            long[] B = new long[N];
            for (int i = 0; i < N; i++) {
                A[i] = in.Long();
                B[i] = in.Long();
            }

            TreeMap<E.Pair, Integer> map = new TreeMap<>();
            int zero = 0;
            for (int i = 0; i < N; i++) {
                if (A[i] == 0 && B[i] == 0) {
                    zero++;
                    continue;
                }
                E.Pair p = new E.Pair(A[i], B[i]);
                map.put(p, map.getOrDefault(p, 0) + 1);
            }

            Set<E.Pair> set = new TreeSet<>();
            long ans = 1;
            for (Map.Entry<E.Pair, Integer> e : map.entrySet()) {
                E.Pair p = e.getKey();
                if (set.contains(p)) {
                    continue;
                }
                E.Pair p2 = new E.Pair(p.v, -p.k);
                if (map.containsKey(p2)) {
                    long a = modpow(2, e.getValue());
                    long b = modpow(2, map.get(p2));
                    ans *= (a + b - 1) % MOD;
                    set.add(p2);
                } else {
                    ans *= modpow(2, e.getValue());
                }
                ans %= MOD;
            }
            ans += zero - 1;
            ans = (ans + MOD) % MOD;
            out.println(ans);
        }

        static private long modpow(long a, long n) {
            long r = 1;
            while (n > 0) {
                r = r * ((n % 2) != 0 ? a : 1) % MOD;
                a = a * a % MOD;
                n >>= 1;
            }
            return r;
        }

        static long gcd(long a, long b) {
            return b == 0 ? a : gcd(b, a % b);
        }

        static class Pair implements Comparable<E.Pair> {
            long k;
            long v;

            Pair(long _k, long _v) {
                k = _k;
                v = _v;
                long g = gcd(k, v);
                if (g != 0) {
                    k /= g;
                    v /= g;
                }
                if (k < 0) {
                    k *= -1;
                    v *= -1;
                }
            }

            public int compareTo(E.Pair o) {
                int c = Long.compare(this.k, o.k);
                if (c == 0) c = Long.compare(this.v, o.v);
                return c;
            }

            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                E.Pair pair = (E.Pair) o;
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

