import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Set;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
        ABC097C solver = new ABC097C();
        solver.solve(1, in, out);
        out.close();
    }

    static class ABC097C {
        public void solve(int testNumber, MyScanner in, PrintWriter out) {
            String s = in.next();
            int K = in.Int();

            Set<String> set = new HashSet<>();
            Set<String> set2 = new HashSet<>();
            int length = s.length();
            for (int j = 0; j < 26; j++) {
                String c = String.valueOf((char) ('a' + j));
                int idx = s.indexOf(c);
                while (idx >= 0) {
                    for (int i = idx + 1; i <= length; i++) {
                        set2.add(s.substring(idx, i));
                        if (set2.size() >= K) {
                            break;
                        }
                    }
                    set.addAll(set2);
                    set2.clear();
                    idx = s.indexOf(c, idx + 1);
                }
                if (set.size() >= K) {
                    break;
                }
            }


            List<String> list = new ArrayList<>(set);
            list.sort(Comparator.naturalOrder());
            out.println(list.get(K - 1));
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

