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
            int[] c = in.Int(9);
            int[] a = new int[3];
            int[] b = new int[3];
            for (int i = 0; i <= 100; i++) {
                for (int j = 0; j <= 100; j++) {
                    for (int k = 0; k <= 100; k++) {
                        a[0] = i;
                        a[1] = j;
                        a[2] = k;
                        b[0] = c[0] - a[0];
                        b[1] = c[4] - a[1];
                        b[2] = c[8] - a[2];
                        if (a[0] + b[1] == c[1] &&
                                a[0] + b[2] == c[2] &&
                                a[1] + b[0] == c[3] &&
                                a[1] + b[2] == c[5] &&
                                a[2] + b[0] == c[6] &&
                                a[2] + b[1] == c[7]) {
                            out.println("Yes");
                            return;
                        }
                    }
                }
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

