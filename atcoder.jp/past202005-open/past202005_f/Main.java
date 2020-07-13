import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
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
        F solver = new F();
        solver.solve(1, in, out);
        out.close();
    }

    static class F {
        public void solve(int testNumber, MyScanner in, PrintWriter out) {
            int N = in.Int();
            char[][] a = new char[N][];
            for (int i = 0; i < N; i++) {
                a[i] = in.next().toCharArray();
                Arrays.sort(a[i]);
            }

            List<Character> list = new ArrayList<>();
            for (int i = 0; i < N / 2; i++) {
                boolean f = false;
                for (int j = 0; j < N; j++) {
                    int idx = Arrays.binarySearch(a[N - 1 - i], a[i][j]);
                    if (idx >= 0) {
                        list.add(a[i][j]);
                        f = true;
                        break;
                    }
                }
                if (!f) {
                    out.println(-1);
                    return;
                }
            }
            List<Character> rev = new ArrayList<>(list.subList(0, list.size()));
            Collections.reverse(rev);
            if (N % 2 == 1) list.add(a[N / 2][0]);
            list.addAll(rev);
            StringBuilder sb = new StringBuilder();
            list.forEach(c -> sb.append((char) c));
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

