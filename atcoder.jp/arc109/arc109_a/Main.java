import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.Collection;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.Deque;
import java.util.ArrayDeque;
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
        int a;
        int b;
        int x;
        int y;

        public void solve(int testNumber, MyScanner in, PrintWriter out) {
            a = in.Int();
            b = in.Int();
            x = in.Int();
            y = in.Int();

            int[][] cost = new int[102][2];
            for (int[] ints : cost) {
                Arrays.fill(ints, 999999999);
            }
            cost[a][0] = 0;
            Deque<int[]> que = new ArrayDeque<>();
            que.add(new int[]{a, 0});
            while (!que.isEmpty()) {
                int[] p = que.removeFirst();
                int c = cost[p[0]][p[1]];
                if (p[1] == 0) {
                    if (p[0] > 1) {
                        if (cost[p[0] - 1][0] > c + y) {
                            cost[p[0] - 1][0] = c + y;
                            que.add(new int[]{p[0] - 1, 0});
                        }
                        if (cost[p[0] - 1][1] > c + x) {
                            cost[p[0] - 1][1] = c + x;
                            que.add(new int[]{p[0] - 1, 1});
                        }
                    }
                    if (p[0] < 100) {
                        if (cost[p[0] + 1][0] > c + y) {
                            cost[p[0] + 1][0] = c + y;
                            que.add(new int[]{p[0] + 1, 0});
                        }
                    }
                    if (cost[p[0]][1] > c + x) {
                        cost[p[0]][1] = c + x;
                        que.add(new int[]{p[0], 1});
                    }
                } else {
                    if (p[0] > 1) {
                        if (cost[p[0] - 1][1] > c + y) {
                            cost[p[0] - 1][1] = c + y;
                            que.add(new int[]{p[0] - 1, 1});
                        }
                    }
                    if (p[0] < 100) {
                        if (cost[p[0] + 1][1] > c + y) {
                            cost[p[0] + 1][1] = c + y;
                            que.add(new int[]{p[0] + 1, 1});
                        }
                        if (cost[p[0] + 1][0] > c + x) {
                            cost[p[0] + 1][0] = c + x;
                            que.add(new int[]{p[0] + 1, 0});
                        }
                    }
                    if (cost[p[0]][0] > c + x) {
                        cost[p[0]][0] = c + x;
                        que.add(new int[]{p[0], 0});
                    }
                }
            }
            out.println(cost[b][1]);
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

