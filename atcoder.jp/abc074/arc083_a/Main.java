import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.Set;
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
        int A;
        int B;
        int C;
        int D;
        int E;
        int F;

        public void solve(int testNumber, MyScanner in, PrintWriter out) {
            A = in.Int();
            B = in.Int();
            C = in.Int();
            D = in.Int();
            E = in.Int();
            F = in.Int();

            Set<Integer> water = new HashSet<>();
            Set<Integer> sugar = new HashSet<>();
            for (int i = 0; i <= 30; i++) {
                for (int j = 0; j <= 30; j++) {
                    int w = A * i + B * j;
                    if (w <= F) {
                        water.add(w);
                    }
                }
            }
            int m = E * F / 100 + 1;
            for (int i = 0; i <= m; i++) {
                for (int j = 0; j <= m; j++) {
                    int s = C * i + D * j;
                    if (s <= m) {
                        sugar.add(s);
                    }
                }
            }


            int[] ans = new int[2];
            double p = -1;
            for (int w : water) {
                for (int s : sugar) {
                    if (w * 100 + s <= F && s <= w * E) {
                        double tmp = 100.0 * s / (w * 100.0 + s);
                        if (p - tmp < 0) {
                            p = tmp;
                            ans[0] = w * 100 + s;
                            ans[1] = s;
                        }
                    }
                }
            }
            out.println(ans[0] + " " + ans[1]);
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

