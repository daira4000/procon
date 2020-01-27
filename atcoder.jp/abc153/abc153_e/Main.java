import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
        E solver = new E();
        solver.solve(1, in, out);
        out.close();
    }

    static class E {
        public void solve(int testNumber, MyScanner in, PrintWriter out) {
            int H = in.nextInt();
            int N = in.nextInt();
            List<Magic> list = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                list.add(new Magic(in.nextInt(), in.nextInt()));
            }
            long ans = calc(H, list);
            out.println(ans);
        }

        private long calc(int H, List<Magic> list) {
            long[] dp = new long[H + 1];
            Arrays.fill(dp, (long) 1e16);
            dp[0] = 0;
            for (int i = 0; i <= H; i++) {
                for (Magic m : list) {
                    int a = Math.min(H, i + m.A);
                    dp[a] = Math.min(dp[a], dp[i] + m.B);
                }
            }
            return dp[H];
        }

        class Magic {
            int A;
            int B;

            Magic(int a, int b) {
                A = a;
                B = b;
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

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

