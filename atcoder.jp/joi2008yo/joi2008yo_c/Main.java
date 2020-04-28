import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.TreeSet;
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
            int n = in.Int();
            TreeSet<Integer> taro = new TreeSet<>();
            TreeSet<Integer> hanako = new TreeSet<>();
            for (int i = 0; i < n; i++) {
                taro.add(in.Int());
            }
            for (int i = 1; i <= n * 2; i++) {
                if (!taro.contains(i)) hanako.add(i);
            }

            TreeSet<Integer> current = taro;
            int no = 0;
            while (true) {
                Integer temp = current.ceiling(no);
                if (temp == null) {
                    no = 0;
                } else {
                    no = temp;
                    current.remove(temp);
                }
                if (current.isEmpty()) break;
                current = current == taro ? hanako : taro;
            }
            out.println(hanako.size());
            out.println(taro.size());
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

