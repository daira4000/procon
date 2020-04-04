import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.stream.Stream;
import java.util.StringTokenizer;
import java.util.Collection;
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
        E solver = new E();
        solver.solve(1, in, out);
        out.close();
    }

    static class E {
        public void solve(int testNumber, MyScanner in, PrintWriter out) {
            int N = in.nextInt();
            int K = in.nextInt();
            int C = in.nextInt();
            char[] S = in.next().toCharArray();


            int p = 0;
            int[] a1 = new int[N];
            int cnt = 1;
            while (p < N) {
                while (p < N && S[p] == 'x') p++;
                if (p >= N) break;
                a1[p] = cnt++;
                p += C + 1;
                if (cnt > K) break;
            }

            p = N - 1;
            int[] a2 = new int[N];
            cnt = K;
            while (p >= 0) {
                while (p >= 0 && S[p] == 'x') p--;
                if (p < 0) break;
                a2[p] = cnt--;
                p -= C + 1;
                if (cnt < 0) break;
            }
            TreeSet<Integer> ans = new TreeSet<>();
            for (int i = 0; i < N; i++) {
                if (a1[i] > 0 && a1[i] == a2[i]) ans.add(i + 1);
            }
            ans.stream().sorted().forEach(out::println);
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

