import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Map;
import java.util.Map.Entry;
import java.io.BufferedReader;
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
        I solver = new I();
        solver.solve(1, in, out);
        out.close();
    }

    static class I {
        public void solve(int testNumber, MyScanner in, PrintWriter out) {
            int N = in.nextInt();
            int M = in.nextInt();

            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < M; i++) {
                String S = in.next();
                int C = in.nextInt();
                int s = Integer.valueOf(S.replace('Y', '1').replace('N', '0'), 2);
                map.put(s, Math.min(map.getOrDefault(s, C), C));
            }

            long[] dp = new long[(int) Math.pow(2, N)];
            long maxval = (long) 1e15;
            Arrays.fill(dp, maxval);
            dp[0] = 0;
            for (Map.Entry<Integer, Integer> e : map.entrySet()) {
                for (int i = 0; i < dp.length; i++) {
                    int k = i | e.getKey();
                    dp[k] = Math.min(dp[k], dp[i] + e.getValue());
                }
            }
            long ans = dp[dp.length - 1];
            out.println(ans == maxval ? -1 : ans);
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

