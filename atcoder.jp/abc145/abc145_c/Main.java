import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
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
            int N = in.nextInt();
            List<C.City> col = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                C.City city = new C.City();
                city.x = in.nextInt();
                city.y = in.nextInt();
                col.add(city);
            }

            List<Double> len = new ArrayList<>();
            double sum = 0;
            for (int i = 0; i < N; i++) {
                double temp = 0;
                for (int j = 0; j < N; j++) {
                    C.City c1 = col.get(i);
                    C.City c2 = col.get(j);
                    double pow1 = Math.pow(c1.x - c2.x, 2);
                    double pow2 = Math.pow(c1.y - c2.y, 2);
                    double sqrt = Math.sqrt(pow1 + pow2);
                    temp += sqrt;
                }
                sum += temp * fact(N - 1);
            }
            out.printf("%.10f", sum / fact(N));
        }

        private double fact(double n) {
            if (n <= 1) {
                return 1;
            }
            return n * fact(n - 1);
        }

        static class City {
            int x;
            int y;

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

