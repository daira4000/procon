import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
        int N;
        int[] P;

        public void solve(int testNumber, MyScanner in, PrintWriter out) {
            N = in.Int();
            P = in.Int(N);

            int[] pos = new int[N + 1];
            for (int i = 0; i < N; i++) {
                pos[P[i]] = i;
            }
            ArrayList<Integer> ans = new ArrayList<>();
            boolean[] f = new boolean[N - 1];
            for (int i = 0; i < N; i++) {
                int p = pos[i + 1];
                if (p != i) {
                    for (int j = p - 1; j >= i; j--) {
                        if (f[j]) {
                            out.println(-1);
                            return;
                        }
                        int temp = P[j + 1];
                        P[j + 1] = P[j];
                        P[j] = temp;
                        pos[P[j + 1]] = j + 1;
                        ans.add(j + 1);
                        f[j] = true;
                    }
                    pos[i + 1] = i;
                }
            }
            for (boolean a : f) {
                if (!a) {
                    out.println(-1);
                    return;
                }
            }
            ans.forEach(out::println);
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

