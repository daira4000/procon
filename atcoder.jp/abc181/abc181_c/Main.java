import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.Comparator;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.util.ArrayList;

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
        List<int[]> list = new ArrayList<>();

        public void solve(int testNumber, MyScanner in, PrintWriter out) {
            N = in.Int();
            for (int i = 0; i < N; i++) {
                list.add(in.Int(2));
            }
            list.sort(Comparator.comparingInt((int[] o) -> o[0]).thenComparingInt(o -> o[1]));

            boolean f = false;
            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    for (int k = j + 1; k < N; k++) {
                        int[] a = list.get(i);
                        int[] b = list.get(j);
                        int[] c = list.get(k);
                        if (a[0] == b[0]) {
                            f = b[0] == c[0];
                        } else if (a[1] == b[1]) {
                            f = b[1] == c[1];
                        } else {
                            int dx1 = b[0] - a[0];
                            int dx2 = c[0] - a[0];
                            int dy1 = b[1] - a[1];
                            int dy2 = c[1] - a[1];
                            f = dx2 * dy1 == dx1 * dy2;
                        }
                        if (f) {
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

