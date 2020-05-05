import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.stream.IntStream;
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
        I solver = new I();
        solver.solve(1, in, out);
        out.close();
    }

    static class I {
        public void solve(int testNumber, MyScanner in, PrintWriter out) {
            int N = in.Int();
            int M = (int) Math.pow(2, N);
            int[] A = in.Int(M);
            int[] pos = new int[A.length];
            for (int i = 0; i < N; i++) {
                int p = (int) Math.pow(2, i + 1);
                for (int j = 0; j < M; j += p) {
                    List<Integer> list = new ArrayList<>();
                    for (int k = j; k < j + p; k++) {
                        if (pos[k] == 0) list.add(k);
                    }
                    int l = list.get(0);
                    int r = list.get(1);
                    if (i + 1 == N) {
                        pos[l] = i + 1;
                        pos[r] = i + 1;
                    } else if (A[l] < A[r]) {
                        pos[l] = i + 1;
                    } else {
                        pos[r] = i + 1;
                    }
                }
            }

            IntStream.of(pos).forEach(out::println);
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

        public int[] Int(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Int();
            }
            return a;
        }

    }
}

