import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.AbstractCollection;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.util.Comparator;
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

            PriorityQueue<int[]> que = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
            for (int i = 0; i < N; i++) {
                int t = in.Int();
                int x = in.Int();
                int y = in.Int();
                que.add(new int[]{t, x, y});
            }

            int[] c = new int[]{0, 0, 0};
            while (!que.isEmpty()) {
                int[] q = que.poll();
                int t = c[0] + Math.abs(c[1] - q[1]) + Math.abs(c[2] - q[2]);
                int d = q[0] - t;
                if (q[0] < t || d < 0 || d % 2 == 1) {
                    out.println("No");
                    return;
                }
            }
            out.println("Yes");
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

