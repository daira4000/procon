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
        int a1;
        int a2;
        int a3;
        int ans;

        public void solve(int testNumber, MyScanner in, PrintWriter out) {
            a1 = in.nextInt();
            a2 = in.nextInt();
            a3 = in.nextInt();
            dfs(0, 0, 0);
            out.println(ans);
        }

        private void dfs(int a, int b, int c) {
            if (a < b || b < c) {
                return;
            }
            if (a > a1 || b > a2 || c > a3) {
                return;
            }
            if (a + b + c == a1 + a2 + a3) {
                ans++;
                return;
            }
            dfs(a + 1, b, c);
            dfs(a, b + 1, c);
            dfs(a, b, c + 1);
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

