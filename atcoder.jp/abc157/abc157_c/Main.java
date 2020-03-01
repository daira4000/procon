import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.Map;
import java.util.HashMap;
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
            int N = in.nextInt();
            int M = in.nextInt();
            int[] ans = new int[N];
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < M; i++) {
                int s = in.nextInt();
                int c = in.nextInt();
                if (map.containsKey(s) && map.get(s) != c) {
                    out.println(-1);
                    return;
                }
                map.put(s, c);
                ans[s - 1] = c;
            }
            if (N > 1 && map.getOrDefault(1, 1) == 0) {
                out.println(-1);
            } else {
                if (N > 1 && ans[0] == 0) ans[0] = 1;
                int a = 0;
                for (int i = 0; i < N; i++) {
                    a = a * 10 + ans[i];
                }
                out.println(a);
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

