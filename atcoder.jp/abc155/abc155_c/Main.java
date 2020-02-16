import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
            HashMap<String, C.Item> col = new HashMap<>();
            for (int i = 0; i < N; i++) {
                String S = in.next();
                if (!col.containsKey(S)) {
                    col.put(S, new C.Item(S));
                }
                col.get(S).count++;
            }
            List<String> items = new ArrayList<>();
            int max = 0;
            for (C.Item item : col.values()) {
                if (max < item.count) {
                    max = item.count;
                    items.clear();
                    items.add(item.S);
                } else if (max == item.count) {
                    items.add(item.S);
                }
            }
            items.sort(String::compareTo);
            for (String S : items) {
                out.println(S);
            }
        }

        static class Item {
            String S;
            int count;

            Item(String S) {
                this.S = S;
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

