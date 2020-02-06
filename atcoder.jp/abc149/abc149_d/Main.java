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
        D solver = new D();
        solver.solve(1, in, out);
        out.close();
    }

    static class D {
        public void solve(int testNumber, MyScanner in, PrintWriter out) {
            int N = in.nextInt();
            int K = in.nextInt();
            int R = in.nextInt();
            int S = in.nextInt();
            int P = in.nextInt();
            String T = in.next();

            long score = 0;
            for (int i = 0; i < K; i++) {
                char hand = ' ';
                for (int j = i; j < N; j += K) {
                    char c = T.charAt(j);
                    if (c == 'r') {
                        if (hand == 'p') {
                            hand = ' ';
                        } else {
                            hand = 'p';
                            score += P;
                        }
                    } else if (c == 's') {
                        if (hand == 'r') {
                            hand = ' ';
                        } else {
                            hand = 'r';
                            score += R;
                        }
                    } else if (c == 'p') {
                        if (hand == 's') {
                            hand = ' ';
                        } else {
                            hand = 's';
                            score += S;
                        }
                    }
                }
            }
            out.println(score);
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

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

