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
        B solver = new B();
        solver.solve(1, in, out);
        out.close();
    }

    static class B {
        public void solve(int testNumber, MyScanner in, PrintWriter out) {
            int[][] A = new int[3][];
            for (int i = 0; i < 3; i++) {
                A[i] = in.nextIntArray(3);
            }
            int N = in.nextInt();
            int[] B = in.nextIntArray(N);
            boolean[][] Ab = new boolean[3][3];
            for (int b : B) {
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (A[i][j] == b) {
                            Ab[i][j] = true;
                        }
                    }
                }
            }
            for (int i = 0; i < 3; i++) {
                if (Ab[i][0] && Ab[i][1] && Ab[i][2]
                        || Ab[0][i] && Ab[1][i] && Ab[2][i]) {
                    out.println("Yes");
                    return;
                }
            }
            if (Ab[0][0] && Ab[1][1] && Ab[2][2]
                    || Ab[0][2] && Ab[1][1] && Ab[2][0]) {
                out.println("Yes");
                return;
            }
            out.println("No");
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

        public int[] nextIntArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextInt();
            }
            return a;
        }

    }
}

