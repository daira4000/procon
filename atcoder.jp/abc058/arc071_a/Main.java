import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;
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
        ABC058C solver = new ABC058C();
        solver.solve(1, in, out);
        out.close();
    }

    static class ABC058C {
        public void solve(int testNumber, MyScanner in, PrintWriter out) {
            int n = in.Int();
            Map<Character, Integer> map = new TreeMap<>();
            String s = in.next();
            for (char c : s.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
            for (int i = 1; i < n; i++) {
                String s2 = in.next();
                Map<Character, Integer> map2 = new TreeMap<>();
                for (char c : s2.toCharArray()) {
                    map2.put(c, map2.getOrDefault(c, 0) + 1);
                }
                for (Map.Entry<Character, Integer> e : map.entrySet()) {
                    map.put(e.getKey(), Math.min(e.getValue(), map2.getOrDefault(e.getKey(), 0)));
                }
                for (Map.Entry<Character, Integer> e : map2.entrySet()) {
                    map.put(e.getKey(), Math.min(e.getValue(), map.getOrDefault(e.getKey(), 0)));
                }
            }

            StringBuilder sb = new StringBuilder();
            for (Map.Entry<Character, Integer> e : map.entrySet()) {
                for (int i = 0; i < e.getValue(); i++) {
                    sb.append(e.getKey());
                }
            }
            out.println(sb.toString());
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

