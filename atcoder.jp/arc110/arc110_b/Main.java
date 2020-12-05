import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.stream.IntStream;
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
        int N;
        String T;
        long MAX = (long) 3e10;

        public void solve(int testNumber, MyScanner in, PrintWriter out) {
            N = in.Int();
            T = in.next();

            if (N == 1) {
                if (T.equals("0")) out.println(MAX / 3);
                else out.println(MAX / 3 * 2);
                return;
            }
            if (N == 2) {
                if (T.equals("00")) out.println(0);
                else if (T.equals("10") || T.equals("11")) out.println(MAX / 3);
                else if (T.equals("01")) out.println(MAX / 3 - 1);
                return;
            }

            StringBuilder sb = new StringBuilder();
            while (sb.length() <= N * 2) {
                sb.append("110");
            }
            if (!sb.toString().contains(T)) {
                out.println(0);
                return;
            }
//        int c = (N - (T.endsWith("110") ? 1 : 0)) / 3;
            long c = T.chars().filter(v -> v == '0').count();
//        out.println(MAX / 3 - c);
            out.println(MAX / 3 - c + (T.charAt(N - 1) == '0' ? 1 : 0));
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

