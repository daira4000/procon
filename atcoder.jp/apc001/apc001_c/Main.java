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
            if (N <= 20) {
                for (int i = 0; i < N; i++) {
                    out.println(i);
                    out.flush();
                    String S = in.next();
                    if (S.equals("Vacant")) return;
                }
            }
            int[] chair = new int[N];
            out.println(0);
            out.flush();
            String S1 = in.next();
            if (S1.equals("Vacant")) return;
            chair[0] = 1;
            int l = -1, r = N;
            while (Math.abs(r - l) > 1) {
                int mid = (l + r) / 2;
                out.println(mid);
                out.flush();
                String S = in.next();
                if (S.equals("Vacant")) return;
                chair[mid] = mid % 2 == 0 && S.equals(S1) || mid % 2 != 0 && !S.equals(S1) ? 1 : 2;
                boolean f = chair[mid] == chair[0];
                if (f) {
                    l = mid;
                } else {
                    r = mid;
                }
            }
            out.println(r);
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

