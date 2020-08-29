import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;
import java.util.stream.Stream;
import java.util.StringTokenizer;
import java.util.Map;
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
        int N;
        int[] A;

        public void solve(int testNumber, MyScanner in, PrintWriter out) {
            N = in.Int();
            A = in.Int(N);

//        out.println(func1());
            out.println(func2());
        }

        private String func2() {
            boolean[] f = new boolean[1001];
            Arrays.fill(f, true);
            f[0] = f[1] = false;
            for (int i = 2; i < f.length; i++) {
                if (f[i]) {
                    for (int j = i * 2; j < f.length; j += i) {
                        f[j] = false;
                    }
                }
            }
            TreeSet<Integer> prims = new TreeSet<>(Comparator.naturalOrder());
            for (int i = 0; i < f.length; i++) {
                if (f[i]) prims.add(i);
            }

            Map<Integer, Integer> map = new HashMap<>();
            for (int n = 0; n < N; n++) {
                int a = A[n];
                for (int p : prims) {
                    if (p > a) break;
                    if (a % p == 0) {
                        map.put(p, map.getOrDefault(p, 0) + 1);
                        while (a % p == 0) {
                            a /= p;
                        }
                    }
                }
                if (a > 1) {
                    map.put(a, map.getOrDefault(a, 0) + 1);
                }
            }

            boolean pc = false;
            boolean sc = false;
            pc = map.values().stream().allMatch(n -> n == 1);
            sc = map.values().stream().allMatch(n -> n < N);
            if (pc) return "pairwise coprime";
            if (sc) return "setwise coprime";
            return "not coprime";
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

