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
import java.util.ArrayList;
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
            int N = in.nextInt();
            List<B.Robot> list = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                int X = in.nextInt();
                int L = in.nextInt();
                list.add(new B.Robot(X - L, X + L));
            }
            list.sort(Comparator.comparingInt(o -> o.r));

            int cur = (int) (-1e9 - 1);
            int ans = 0;
            for (int i = 0; i < N; i++) {
                B.Robot robot = list.get(i);
                if (cur <= robot.l) {
                    cur = robot.r;
                    ans++;
                }
            }
            out.println(ans);
        }

        static class Robot {
            int l;
            int r;

            Robot(int l, int r) {
                this.l = l;
                this.r = r;
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

