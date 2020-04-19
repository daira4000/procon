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
            int N = in.Int();
            int[] A = new int[N];
            int[] B = new int[N];
            for (int i = 0; i < N; i++) {
                A[i] = in.Int();
                B[i] = in.Int();
            }

            int s, g;
            s = g = 0;
            long temps, tempg;
            temps = tempg = 1L << 62;
            for (int i = 0; i < N; i++) {
                long tempss = 0;
                long tempgg = 0;
                for (int j = 0; j < N; j++) {
                    tempss += Math.abs(A[i] - A[j]);
                    tempgg += Math.abs(B[i] - B[j]);
                }
                if (temps > tempss) {
                    s = A[i];
                    temps = tempss;
                }
                if (tempg > tempgg) {
                    g = B[i];
                    tempg = tempgg;
                }
            }

            long sum = 0;
            for (int i = 0; i < N; i++) {
                sum += Math.abs(s - A[i]) + Math.abs(A[i] - B[i]) + Math.abs(B[i] - g);
            }
            out.println(sum);
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

