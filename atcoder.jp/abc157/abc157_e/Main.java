import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;
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
        E solver = new E();
        solver.solve(1, in, out);
        out.close();
    }

    static class E {
        public void solve(int testNumber, MyScanner in, PrintWriter out) {
            int N = in.nextInt();
            char[] S = in.next().toCharArray();
            Map<Integer, TreeSet<Integer>> map = new HashMap<>();
            for (int i = 'a'; i <= 'z'; i++) {
                map.put(i, new TreeSet<>());
            }
            for (int i = 0; i < N; i++) {
                map.get((int) S[i]).add(i + 1);
            }
            int Q = in.nextInt();
            for (int i = 0; i < Q; i++) {
                int type = in.nextInt();
                if (type == 1) {
                    Integer iq = in.nextInt();
                    int cq = in.next().charAt(0);
                    int c = S[iq - 1];
                    if (!map.get(cq).contains(iq)) {
                        map.get(c).remove(iq);
                        map.get(cq).add(iq);
                        S[iq - 1] = (char) cq;
                    }
                } else {
                    int lq = in.nextInt();
                    int rq = in.nextInt();
                    int cnt = 0;
                    for (Map.Entry<Integer, TreeSet<Integer>> e : map.entrySet()) {
                        TreeSet<Integer> value = e.getValue();
                        Integer v = value.ceiling(lq);
                        if (v != null && v <= rq) {
                            cnt++;
                        }
                    }
                    out.println(cnt);
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

        public int nextInt() {
            return Integer.parseInt(next());
        }

    }
}

