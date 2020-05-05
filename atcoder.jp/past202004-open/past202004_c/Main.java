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
            int N = in.Int();
            char[][] S = new char[N][];
            for (int i = 0; i < N; i++) {
                S[i] = in.next().toCharArray();
            }
            for (int i = N - 1; i >= 1; i--) {
                for (int j = 0; j < 2 * N - 1; j++) {
                    if (S[i][j] != 'X') continue;
                    if (j - 1 >= 0 && S[i - 1][j - 1] == '#') S[i - 1][j - 1] = 'X';
                    if (S[i - 1][j] == '#') S[i - 1][j] = 'X';
                    if (j + 1 < 2 * N - 1 && S[i - 1][j + 1] == '#') S[i - 1][j + 1] = 'X';
                }
            }
            for (int i = 0; i < N; i++) {
                out.println(new String(S[i]));
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

        public int Int() {
            return Integer.parseInt(next());
        }

    }
}

