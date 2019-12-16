import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.stream.IntStream;
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
        C solver = new C();
        solver.solve(1, in, out);
        out.close();
    }

    static class C {
        public void solve(int testNumber, MyScanner in, PrintWriter out) {
            int N = in.nextInt();
            int D = in.nextInt();
            int K = in.nextInt();
            int[] L = new int[D];
            int[] R = new int[D];
            for (int i = 0; i < D; i++) {
                L[i] = in.nextInt();
                R[i] = in.nextInt();
            }
            int[] S = new int[K];
            int[] T = new int[K];
            boolean[] rev = new boolean[K];
            for (int i = 0; i < K; i++) {
                S[i] = in.nextInt();
                T[i] = in.nextInt();
                rev[i] = S[i] > T[i];
            }

            int[] cur = Arrays.copyOf(S, S.length);
            int[] ans = new int[K];
            for (int i = 0; i < D; i++) {
                for (int j = 0; j < K; j++) {
                    if (!rev[j]) {
                        if (L[i] <= cur[j] && cur[j] < R[i]) {
                            cur[j] = R[i];
                            if (T[j] <= cur[j]) {
                                cur[j] = -1;
                                ans[j] = i + 1;
                            }
                        }
                    } else {
                        if (L[i] < cur[j] && cur[j] <= R[i]) {
                            cur[j] = L[i];
                            if (cur[j] <= T[j]) {
                                cur[j] = -1;
                                ans[j] = i + 1;
                            }
                        }
                    }
                }
            }
            Arrays.stream(ans).forEach(out::println);
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

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

