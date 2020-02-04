import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.stream.IntStream;
import java.util.Arrays;
import java.io.IOException;
import java.util.stream.Collectors;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.util.Comparator;
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
        C solver = new C();
        solver.solve(1, in, out);
        out.close();
    }

    static class C {
        public void solve(int testNumber, MyScanner in, PrintWriter out) {
            int N = in.nextInt();
            int[] P = in.nextIntArray(N);
            int[] Q = in.nextIntArray(N);

            List<String> perm = perm(IntStream.rangeClosed(1, N).boxed().collect(Collectors.toList()));
            perm.sort(Comparator.naturalOrder());
            String pl = Arrays.stream(P).boxed().map(String::valueOf).collect(Collectors.joining());
            String ql = Arrays.stream(Q).boxed().map(String::valueOf).collect(Collectors.joining());
            int pi = 0, qi = 0;
            for (int i = 0; i < perm.size(); i++) {
                if (perm.get(i).equals(pl)) {
                    pi = i + 1;
                }
                if (perm.get(i).equals(ql)) {
                    qi = i + 1;
                }
            }
            out.println(Math.abs(pi - qi));
        }

        private List<String> perm(List<Integer> list) {
            if (list.size() == 1) {
                return Collections.singletonList(list.get(0).toString());
            }
            List<String> ret = new ArrayList<>();
            List<Integer> temp = new ArrayList<>(list);
            for (int i = 0; i < list.size(); i++) {
                Integer a = temp.remove(0);
                List<String> p = perm(temp);
                temp.add(a);
                for (int j = 0; j < p.size(); j++) {
                    ret.add(a.toString() + p.get(j));
                }
            }
            return ret;
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

        public int[] nextIntArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextInt();
            }
            return a;
        }

    }
}

