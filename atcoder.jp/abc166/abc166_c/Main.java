import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Map;
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
        C solver = new C();
        solver.solve(1, in, out);
        out.close();
    }

    static class C {
        public void solve(int testNumber, MyScanner in, PrintWriter out) {
            int N = in.Int();
            int M = in.Int();
            int[] H = in.Int(N);
            int[] A = new int[M];
            int[] B = new int[M];
            for (int i = 0; i < M; i++) {
                A[i] = in.Int() - 1;
                B[i] = in.Int() - 1;
            }

            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int i = 0; i < N; i++) {
                map.put(i, new ArrayList<>());
            }
            for (int i = 0; i < M; i++) {
                map.get(A[i]).add(B[i]);
                map.get(B[i]).add(A[i]);
            }
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                int ha = H[i];
                if (map.get(i).size() > 0) {
                    boolean f = true;
                    for (int bi : map.get(i)) {
                        int hb = H[bi];
                        if (ha <= hb) {
                            f = false;
                            break;
                        }
                    }
                    if (f) {
                        cnt++;
                    }
                } else {
                    cnt++;
                }
            }
            out.println(cnt);
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

        public int[] Int(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Int();
            }
            return a;
        }

    }
}

