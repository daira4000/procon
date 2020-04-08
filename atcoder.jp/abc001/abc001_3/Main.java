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
        C solver = new C();
        solver.solve(1, in, out);
        out.close();
    }

    static class C {
        public void solve(int testNumber, MyScanner in, PrintWriter out) {
            TreeMap<Integer, String> muki = new TreeMap<>();
            muki.put(1125, "N");
            muki.put(3375, "NNE");
            muki.put(5625, "NE");
            muki.put(7875, "ENE");
            muki.put(10125, "E");
            muki.put(12375, "ESE");
            muki.put(14625, "SE");
            muki.put(16875, "SSE");
            muki.put(19125, "S");
            muki.put(21375, "SSW");
            muki.put(23625, "SW");
            muki.put(25875, "WSW");
            muki.put(28125, "W");
            muki.put(30375, "WNW");
            muki.put(32625, "NW");
            muki.put(34875, "NNW");
            muki.put(99999, "N");
            double[] kaze = new double[]{
                    0.2, 1.5, 3.3, 5.4, 7.9,
                    10.7, 13.8, 17.1, 20.7, 24.4,
                    28.4, 32.6, 200.0
            };

            int Deg = in.nextInt() * 10;
            int Dis = in.nextInt();

            String Dir = "N";
            for (Map.Entry<Integer, String> e : muki.entrySet()) {
                if (Deg < e.getKey()) {
                    Dir = e.getValue();
                    break;
                }
            }
            int W = 0;
            double tmp = Math.round(Dis * 10.0 / 60) / 10.0;
            for (int i = 0; i < kaze.length; i++) {
                if (tmp <= kaze[i]) {
                    W = i;
                    break;
                }
            }
            if (W == 0) Dir = "C";

            out.printf("%S %d\n", Dir, W);
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

