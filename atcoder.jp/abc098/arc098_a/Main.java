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
            String S = in.next();
            int[] ec = new int[N + 1];
            int[] wc = new int[N + 1];
            for (int i = 0; i < N; i++) {
                ec[i + 1] = ec[i] + (S.charAt(i) == 'E' ? 1 : 0);
                wc[N - 1 - i] = wc[N - i] + (S.charAt(N - 1 - i) == 'W' ? 1 : 0);
            }
            int min = Integer.MAX_VALUE;
            for (int i = 0; i <= N; i++) {
                int temp;
//            if (i == 0) {
//                temp = ec[N] - ec[i + 1];
//            } else if (i == N) {
//                temp = wc[0] - wc[i - 1];
//            } else {
//                temp = wc[0] - wc[i - 1] + ec[N] - ec[i + 1];
//            }
                temp = wc[0] - wc[i] + ec[N] - ec[i];
                min = Math.min(min, temp);
            }
            out.println(min);
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

