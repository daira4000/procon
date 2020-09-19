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
        E solver = new E();
        solver.solve(1, in, out);
        out.close();
    }

    static class E {
        long N;
        int X;
        int M;

        public void solve(int testNumber, MyScanner in, PrintWriter out) {
            N = in.Long();
            X = in.Int();
            M = in.Int();

//        out.println(func1());
//        out.println(func2());
            out.println(func3());
        }

        long func3() {
            Map<Integer, Integer> map = new HashMap<>();
            int cur = X;
            while (!map.containsKey(cur)) {
                int nxt = (int) (((long) cur * cur) % M);
                map.put(cur, nxt);
                cur = nxt;
            }
            boolean[] f = new boolean[M + 1];
            long[] suma = new long[map.size() + 2];
            List<Integer> vs = new ArrayList<>();
            cur = X;
            vs.add(cur);
            suma[1] = cur;
            int idx = 1;
            int st = 0;
            while (true) {
                if (f[cur]) {
                    st = vs.indexOf(cur);
                    break;
                }
                f[cur] = true;
                int nxt = map.get(cur);
                suma[idx + 1] = suma[idx] + nxt;
                vs.add(nxt);
                idx++;
                cur = nxt;
            }

            long ret = 0;
            int size = map.size();
            if (N <= size) {
                ret = suma[(int) N];
            } else {
                if (vs.contains(0L)) {
                    ret = suma[size];
                } else {
                    ret = suma[st] + (suma[size] - suma[st]) * ((N - st) / (size - st));
                    int i = (int) ((N - st) % (size - st));
                    if (i > 0) {
                        ret += suma[st + i] - suma[st];
                    }
                }
            }
            return ret;
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

        public long Long() {
            return Long.parseLong(next());
        }

    }
}

