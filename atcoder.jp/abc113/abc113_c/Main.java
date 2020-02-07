import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.StringTokenizer;
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
            int M = in.nextInt();
            List<C.City> list = new ArrayList<>();
            List<C.City> list2 = new ArrayList<>();
            for (int i = 0; i < M; i++) {
                int P = in.nextInt();
                int Y = in.nextInt();
                C.City c = new C.City(i, P, Y);
                list.add(c);
                list2.add(c);
            }
            list2.sort((o1, o2) -> Integer.compare(o1.Y, o2.Y));
            int[] nos = new int[N + 1];
            for (C.City city : list2) {
                city.no = ++nos[city.P];
            }
            for (C.City city : list) {
                out.printf("%06d%06d\n", city.P, city.no);
            }
        }

        static class City {
            int i;
            int P;
            int Y;
            int no;

            City(int i, int P, int Y) {
                this.i = i;
                this.P = P;
                this.Y = Y;
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

