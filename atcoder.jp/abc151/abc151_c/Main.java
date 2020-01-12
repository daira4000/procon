import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
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
            int M = in.nextInt();
            int[] p = new int[M];
            String[] S = new String[M];
            for (int i = 0; i < M; i++) {
                p[i] = in.nextInt();
                S[i] = in.next();
            }

            boolean[] ex = new boolean[N + 1];
            for (int i = 0; i < M; i++) {
                if (ex[p[i]]) {
                    S[i] = "WA";
                }
                if (S[i].equals("AC")) {
                    ex[p[i]] = true;
                }
            }
            boolean[] ac = new boolean[N + 1];
            int[] cnt = new int[2];
            for (int i = M - 1; i >= 0; i--) {
                if (S[i].equals("AC")) {
                    if (!ac[p[i]]) {
                        cnt[0]++;
                        ac[p[i]] = true;
                    }
                } else {
                    if (ac[p[i]]) {
                        cnt[1]++;
                    }
                }
            }
            out.printf("%d %d\n", cnt[0], cnt[1]);
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

