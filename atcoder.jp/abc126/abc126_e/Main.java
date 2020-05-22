import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Set;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;
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
        abc126_e solver = new abc126_e();
        solver.solve(1, in, out);
        out.close();
    }

    static class abc126_e {
        public void solve(int testNumber, MyScanner in, PrintWriter out) {
            int N = in.Int();
            int M = in.Int();
            int[] X = new int[M];
            int[] Y = new int[M];
            int[] Z = new int[M];
            for (int i = 0; i < M; i++) {
                X[i] = in.Int() - 1;
                Y[i] = in.Int() - 1;
                Z[i] = in.Int();
            }

            abc126_e.UnionFind uf = new abc126_e.UnionFind(N);
            for (int i = 0; i < M; i++) {
                uf.connect(X[i], Y[i]);
            }
            Set<Integer> set = new HashSet<>();
            for (int i = 0; i < N; i++) {
                set.add(uf.root(i));
            }
            out.println(set.size());
        }

        static class UnionFind {
            List<Integer> Parent;

            UnionFind(int N) {
                Parent = new ArrayList<Integer>();
                Integer[] values = new Integer[N];
                Arrays.fill(values, -1);
                Parent.addAll(Arrays.asList(values));
            }

            int root(int A) {
                if (Parent.get(A) < 0)
                    return A;
                int root = root(Parent.get(A));
                Parent.set(A, root);
                return root;
            }

            int size(int A) {
                return -Parent.get(root(A));//親をとってきたい]
            }

            boolean connect(int A, int B) {
                A = root(A);
                B = root(B);
                if (A == B) {
                    return false;
                }

                if (size(A) < size(B)) {
                    int temp = A;
                    A = B;
                    B = temp;
                }

                Parent.set(A, Parent.get(A) + Parent.get(B));
                Parent.set(B, A);

                return true;
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

