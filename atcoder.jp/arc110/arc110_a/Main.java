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
        A solver = new A();
        solver.solve(1, in, out);
        out.close();
    }

    static class A {
        int N;

        public void solve(int testNumber, MyScanner in, PrintWriter out) {
            N = in.Int();
            long ans = N;
            for (int i = 2; i <= N; i++) {
                ans = lcm(ans, i);
            }
            ans++;
//        while (true) {
//            boolean f = true;
//            for (int i = 2; i <= N; i++) {
//                if (ans % i != 1) {
//                    f = false;
//                    break;
//                }
//            }
//            if (f) {
//                break;
//            }
//            ans++;
//        }
            out.println(ans);
        }

        long gcd(long a, long b) {
            return b == 0 ? a : gcd(b, a % b);
        }

        long lcm(long a, long b) {
            return a / gcd(a, b) * b;
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

