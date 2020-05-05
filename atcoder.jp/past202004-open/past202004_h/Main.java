import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Map;
import java.io.BufferedReader;
import java.util.Collections;
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
        H solver = new H();
        solver.solve(1, in, out);
        out.close();
    }

    static class H {
        public void solve(int testNumber, MyScanner in, PrintWriter out) {
            int N = in.Int();
            int M = in.Int();

            Map<Integer, List<int[]>> map = new HashMap<>();
            for (int i = 0; i < N; i++) {
                String A = in.next();
                for (int j = 0; j < M; j++) {
                    char c = A.charAt(j);
                    if (c == 'S') {
                        map.put(0, Collections.singletonList(new int[]{i, j, 0}));
                    } else if (c == 'G') {
                        map.put(10, Collections.singletonList(new int[]{i, j, Integer.MAX_VALUE}));
                    } else {
                        Integer key = c - '0';
                        if (!map.containsKey(key)) {
                            map.put(key, new ArrayList<>());
                        }
                        map.get(key).add(new int[]{i, j, Integer.MAX_VALUE});
                    }
                }
            }
            for (int i = 0; i <= 10; i++) {
                if (!map.containsKey(i)) {
                    out.println(-1);
                    return;
                }
            }
            for (int i = 0; i < 10; i++) {
                for (int[] f : map.get(i)) {
                    for (int[] t : map.get(i + 1)) {
                        t[2] = Math.min(t[2], f[2] + Math.abs(f[0] - t[0]) + Math.abs(f[1] - t[1]));
                    }
                }
            }
            out.println(map.get(10).get(0)[2]);
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

