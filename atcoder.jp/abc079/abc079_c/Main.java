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
        ABC079C solver = new ABC079C();
        solver.solve(1, in, out);
        out.close();
    }

    static class ABC079C {
        public void solve(int testNumber, MyScanner in, PrintWriter out) {
            String S = in.next();
            int A = S.charAt(0) - '0';
            int B = S.charAt(1) - '0';
            int C = S.charAt(2) - '0';
            int D = S.charAt(3) - '0';
            int[] ABCD = new int[]{A, B, C, D};

            int loop = 1 << 3;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < loop; i++) {
                sb.setLength(0);
                sb.append(A);
                int ans = A;
                for (int j = 0; j < 3; j++) {
                    if (((i >> j) & 1) == 0) {
                        sb.append('+');
                        ans += ABCD[j + 1];
                    } else {
                        sb.append('-');
                        ans -= ABCD[j + 1];
                    }
                    sb.append(S.charAt(j + 1));
                }
                if (ans == 7) {
                    sb.append("=7");
                    out.println(sb.toString());
                    return;
                }
            }
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

    }
}

