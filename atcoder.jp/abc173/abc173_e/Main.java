import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Function;
import java.util.ArrayList;
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
        E solver = new E();
        solver.solve(1, in, out);
        out.close();
    }

    static class E {
        static long MOD = (long) (1e9 + 7);

        public void solve(int testNumber, MyScanner in, PrintWriter out) {
            int N = in.Int();
            int K = in.Int();
            int[] A = in.Int(N);

            int[][] as = new int[N][2];
            int posi = 0;
            for (int i = 0; i < N; i++) {
                as[i][0] = Math.abs(A[i]);
                as[i][1] = A[i];
                posi += A[i] >= 0 ? 1 : 0;
            }
            if (posi == 0 && K % 2 == 1) {
                Arrays.sort(as, Comparator.comparingInt(v -> v[0]));
            } else {
                Arrays.sort(as, Comparator.comparingInt(v -> -v[0]));
            }
            ArrayList<int[]> t = new ArrayList<>();
            int nega = 0;
            int zero = 0;
            int[] pa = null;
            int[] na = null;
            for (int i = 0; i < N; i++) {
                if (as[i][0] == 0) {
                    zero++;
                    continue;
                }
                if (t.size() < K) {
                    t.add(as[i]);
                    nega += as[i][1] < 0 ? 1 : 0;
                } else {
                    if (pa == null && as[i][1] > 0) pa = as[i];
                    if (na == null && as[i][1] < 0) na = as[i];
                    // if (pa != null && na != null) break;
                }
            }

            if (nega % 2 != 0 && posi > 0 && t.size() == K) {
                t.sort(Comparator.comparingInt(v -> v[1]));
                if (nega == K) {
                    // すべてネガ
                    if (pa != null) {
                        t.remove(K - 1);
                        t.add(pa);
                    } else if (zero > 0) {
                        t.remove(K - 1);
                    }
                } else {
                    int idx = nibu(K, i -> t.get(i)[1] >= 0);
                    int[] fw = t.get(idx - 1);
                    int[] cw = t.get(idx);
                    if (pa != null && na != null && fw != null && cw != null) {
                        if ((long) fw[0] * na[0] > (long) cw[0] * pa[0]) {
                            t.remove(idx);
                            t.add(na);
                        } else {
                            t.remove(idx - 1);
                            t.add(pa);
                        }
                    } else if (pa != null && fw != null) {
                        t.remove(fw);
                        t.add(pa);
                    } else if (na != null && cw != null) {
                        t.remove(cw);
                        t.add(na);
                    }
                }
            }

            if (t.size() < K) {
                out.println(0);
            } else {
                long ans = 1;
                for (int[] v : t) {
                    ans *= v[1];
                    ans %= MOD;
                }
                ans = ans < 0 && zero > 0 ? 0 : ans;
                ans = (ans + MOD) % MOD;
                out.println(ans);
            }
        }

        private int nibu(int n, Function<Integer, Boolean> check) {
            int ng = -1, ok = n;
            while (Math.abs(ok - ng) > 1) {
                int mid = (ng + ok) / 2;
                boolean f = check.apply(mid);
                if (!f) {
                    ng = mid;
                } else {
                    ok = mid;
                }
            }
            return ok;
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

        public int[] Int(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Int();
            }
            return a;
        }

    }
}

