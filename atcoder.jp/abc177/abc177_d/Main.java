import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
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
        int N;
        int M;

        public void solve(int testNumber, MyScanner in, PrintWriter out) {
            N = in.Int();
            M = in.Int();
            var dsu = new DSU(N);
            for (int i = 0; i < M; i++) {
                var A = in.Int() - 1;
                var B = in.Int() - 1;
                dsu.merge(A, B);
            }
            int max = 0;
            for (int i = 0; i < N; i++) {
                max = Math.max(max, dsu.size(i));
            }
            out.println(max);
        }

    }

    static class DSU {
        private int n;
        private int[] parentOrSize;

        public DSU(int n) {
            this.n = n;
            this.parentOrSize = new int[n];
            Arrays.fill(parentOrSize, -1);
        }

        int merge(int a, int b) {
            if (!(0 <= a && a < n))
                throw new IndexOutOfBoundsException("a=" + a);
            if (!(0 <= b && b < n))
                throw new IndexOutOfBoundsException("b=" + b);

            int x = leader(a);
            int y = leader(b);
            if (x == y) return x;
            if (-parentOrSize[x] < -parentOrSize[y]) {
                int tmp = x;
                x = y;
                y = tmp;
            }
            parentOrSize[x] += parentOrSize[y];
            parentOrSize[y] = x;
            return x;
        }

        int leader(int a) {
            if (parentOrSize[a] < 0) {
                return a;
            } else {
                parentOrSize[a] = leader(parentOrSize[a]);
                return parentOrSize[a];
            }
        }

        int size(int a) {
            if (!(0 <= a && a < n))
                throw new IndexOutOfBoundsException("" + a);
            return -parentOrSize[leader(a)];
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

