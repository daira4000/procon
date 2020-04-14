import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.HashMap;
import java.io.IOException;
import java.util.Deque;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Map;
import java.io.BufferedReader;
import java.util.ArrayDeque;
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
        G solver = new G();
        solver.solve(1, in, out);
        out.close();
    }

    static class G {
        public void solve(int testNumber, MyScanner in, PrintWriter out) {
            int N = in.Int();
            int M = in.Int();
            int[] dp = new int[N + 1];
            G.Topological t = new G.Topological(N);
            for (int i = 0; i < M; i++) {
                int x = in.Int();
                int y = in.Int();
                t.addEdge(x - 1, y - 1);
            }
            t.sort();
            for (int x : t.list) {
                for (int y : t.out.get(x)) {
                    dp[y] = Math.max(dp[y], dp[x] + 1);
                }
            }
            out.println(dp[t.list.get(N - 1)]);
        }

        static class Topological {
            int n;
            List<Integer> list = new ArrayList<>();
            int[] in;
            Map<Integer, List<Integer>> out;

            Topological(int n) {
                this.n = n;
                this.in = new int[n];
                this.out = new HashMap<>();
                for (int i = 0; i < n; i++) {
                    out.put(i, new ArrayList<>());
                }
            }

            public void addEdge(int x, int y) {
                in[y]++;
                out.get(x).add(y);
            }

            public void sort() {
                list.clear();
                Deque<Integer> que = new ArrayDeque<>();
                for (int i = 0; i < n; i++) {
                    if (in[i] == 0) {
                        que.add(i);
                    }
                }
                while (!que.isEmpty()) {
                    int i = que.poll();
                    list.add(i);
                    for (int j : out.get(i)) {
                        in[j]--;
                        if (in[j] == 0) {
                            que.add(j);
                        }
                    }
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

