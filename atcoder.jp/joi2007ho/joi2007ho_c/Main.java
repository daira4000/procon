import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.Comparator;
import java.io.InputStreamReader;
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
        C2 solver = new C2();
        solver.solve(1, in, out);
        out.close();
    }

    static class C2 {
        public void solve(int testNumber, MyScanner in, PrintWriter out) {
            int N = in.Int();
            int[][] points = new int[N][2];
            for (int i = 0; i < N; i++) {
                int x = in.Int();
                int y = in.Int();
                points[i] = new int[]{x, y};
            }
            Comparator<int[]> comparator = Comparator.comparingInt((int[] o) -> o[0]).thenComparingInt(o -> o[1]);
            Arrays.sort(points, comparator);

            int size = 0;
            int[] p3 = new int[2];
            int[] p4 = new int[2];
            for (int i = 0; i < N; i++) {
                int[] p1 = points[i];
                for (int j = i + 1; j < N; j++) {
                    int[] p2 = points[j];
                    p3[0] = p1[0] + p2[1] - p1[1];
                    p3[1] = p1[1] - p2[0] + p1[0];
                    if (p3[0] < 0 || p3[1] < 0) continue;
                    if (Arrays.binarySearch(points, p3, comparator) < 0) {
                        p3[0] = p1[0] - p2[1] + p1[1];
                        p3[1] = p1[1] + p2[0] - p1[0];
                        if (p3[0] < 0 || p3[1] < 0) continue;
                        if (Arrays.binarySearch(points, p3, comparator) < 0) {
                            continue;
                        }
                    }
                    p4[0] = p3[0] + (p2[0] - p1[0]);
                    p4[1] = p3[1] + (p2[1] - p1[1]);
                    if (p4[0] < 0 || p4[1] < 0) continue;
                    if (Arrays.binarySearch(points, p4, comparator) >= 0) {
                        size = (int) Math.max(size, Math.pow(p1[0] - p2[0], 2) + Math.pow(p1[1] - p2[1], 2));
                    }
                }
            }
            out.println(size);
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

